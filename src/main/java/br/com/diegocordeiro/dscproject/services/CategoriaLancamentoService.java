package br.com.diegocordeiro.dscproject.services;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.dto.AtivoDTO;
import br.com.diegocordeiro.dscproject.dto.BancoDTO;
import br.com.diegocordeiro.dscproject.repositories.AtivoRepository;
import br.com.diegocordeiro.dscproject.repositories.BancoRepository;
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
public class BancoService {

	@Autowired
	private BancoRepository repositorio;
	
	public Banco buscarPorId(Integer id) {
		Optional<Banco> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Banco.class.getName()));
	}
	
	public List<Banco> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Page<Banco> buscarTodosComPaginacao(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findAll(pageRequest);
	}
	
	@Transactional
	public Banco insert(Banco obj) {
		obj.setId(null);
		repositorio.save(obj);
		return obj;
	}
	
	public Banco update(Banco obj) throws ObjectNotFoundException {
		Banco newObj = buscarPorId(obj.getId());
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
	
	private void updateData(Banco newObj, Banco obj) {
		newObj.setNome(obj.getNome());
	}
	
	public Banco fromDTO(BancoDTO objDto){
		return new Banco(objDto.getId(), objDto.getNumero(), objDto.getNome());
	}
}
