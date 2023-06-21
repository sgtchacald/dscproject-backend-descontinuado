package br.com.diegocordeiro.dscproject.services;

import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.domain.Conta;
import br.com.diegocordeiro.dscproject.dto.BancoDTO;
import br.com.diegocordeiro.dscproject.dto.ContaDTO;
import br.com.diegocordeiro.dscproject.repositories.BancoRepository;
import br.com.diegocordeiro.dscproject.repositories.ContaRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.DataIntegrityException;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repositorio;
	
	public Conta buscarPorId(Integer id) {
		Optional<Conta> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Conta.class.getName()));
	}
	
	public List<Conta> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Page<Conta> buscarTodosComPaginacao(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findAll(pageRequest);
	}
	
	@Transactional
	public Conta insert(Conta obj) {
		obj.setId(null);
		repositorio.save(obj);
		return obj;
	}
	
	public Conta update(Conta obj) throws ObjectNotFoundException {
		Conta newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repositorio.save(newObj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		buscarPorId(id);
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir este registro pois já existem registros vinculados a ele.");
		}
	}
	
	private void updateData(Conta newObj, Conta obj) {
		newObj.setAgencia(obj.getAgencia());
		newObj.setAgenciaDigito(obj.getAgenciaDigito());
		newObj.setConta(obj.getConta());
		newObj.setConta(obj.getContaDigito());
		newObj.setUsuario(obj.getUsuario());
	}
	
	public Conta fromDTO(ContaDTO objDto){
		return new Conta(
			objDto.getId(),
			objDto.getAgencia(),
			objDto.getAgenciaDigito(),
			objDto.getConta(),
			objDto.getContaDigito(),
			objDto.getBanco(),
			objDto.getUsuario()
		);
	}
}
