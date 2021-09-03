package br.com.diegocordeiro.dscproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.dto.AtivoDTO;
import br.com.diegocordeiro.dscproject.repositories.AtivoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.DataIntegrityException;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class AtivoService {

	@Autowired
	private AtivoRepository repositorio;
	
	public Ativo buscarPorId(Integer id) {
		Optional<Ativo> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Ativo.class.getName()));
	}
	
	public List<Ativo> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Page<Ativo> buscarTodosComPaginacao(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findAll(pageRequest);
	}
	
	@Transactional
	public Ativo insert(Ativo obj) {
		obj.setId(null);
		repositorio.save(obj);
		return obj;
	}
	
	public Ativo update(Ativo obj) throws ObjectNotFoundException {
		Ativo newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repositorio.save(newObj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		buscarPorId(id);
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir este ativos pois já existem operações vinculadas a ele.");
		}
	}
	
	private void updateData(Ativo newObj, Ativo obj) {
		newObj.setCodigo(obj.getCodigo());
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
	}
	
	public Ativo fromDTO(AtivoDTO objDto){
		return new Ativo(objDto.getId(), objDto.getCodigo(), objDto.getNome(), objDto.getDescricao());
	}
}
