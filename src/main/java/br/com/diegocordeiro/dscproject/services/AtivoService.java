package br.com.diegocordeiro.dscproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.repositories.AtivoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class AtivoService {

	@Autowired
	private AtivoRepository repositorio;
	
	public Ativo buscarPorId(Integer id) {
		Optional<Ativo> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}
	
	@Transactional
	public Ativo insert(Ativo obj) {
		obj.setId(null);
		repositorio.save(obj);
		return obj;
	}
		
//	public Ativo update(Ativo obj) throws ObjectNotFoundException {
//		Ativo newObj = find(obj.getId());
//		updateData(newObj, obj);
//		repositorio.save(newObj);
//		return newObj;
//	}
//	
//	public void delete(Integer id) throws ObjectNotFoundException {
//		repositorio.find(id);
//		try {
//			repo.delete(id);
//		} catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityException("Não foi possível excluir, pois existem entidades relacionadas, verifique.");
//		}
//	}

}
