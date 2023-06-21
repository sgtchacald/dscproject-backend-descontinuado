package br.com.diegocordeiro.dscproject.services;

import br.com.diegocordeiro.dscproject.domain.CategoriaLancamento;
import br.com.diegocordeiro.dscproject.dto.CategoriaLancamentoDTO;
import br.com.diegocordeiro.dscproject.repositories.CategoriaLancamentoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.DataIntegrityException;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
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
public class CategoriaLancamentoService {

	@Autowired
	private CategoriaLancamentoRepository repositorio;
	
	public CategoriaLancamento buscarPorId(Integer id) {
		Optional<CategoriaLancamento> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " +CategoriaLancamento.class.getName()));
	}
	
	public List<CategoriaLancamento> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Page<CategoriaLancamento> buscarTodosComPaginacao(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findAll(pageRequest);
	}
	
	@Transactional
	public CategoriaLancamento insert(CategoriaLancamento obj) {
		obj.setId(null);
		repositorio.save(obj);
		return obj;
	}
	
	public CategoriaLancamento update(CategoriaLancamento obj) throws ObjectNotFoundException {
		CategoriaLancamento newObj = buscarPorId(obj.getId());
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
	
	private void updateData(CategoriaLancamento newObj,CategoriaLancamento obj) {
		newObj.setNome(obj.getNome());
	}
	
	public CategoriaLancamento fromDTO(CategoriaLancamentoDTO objDto){
		return new CategoriaLancamento(objDto.getId(), objDto.getNome());
	}
}
