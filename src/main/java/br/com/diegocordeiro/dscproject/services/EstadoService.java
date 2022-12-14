package br.com.diegocordeiro.dscproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Estado;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.repositories.EstadoRepository;
import br.com.diegocordeiro.dscproject.repositories.PaisRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private PaisRepository paisRepositorio;

	@Autowired
	private EstadoRepository estadoRepositorio;
	
	public List<Estado> findAll() {
		return estadoRepositorio.findAll();
	}
	
	public Estado buscarPorId(Integer id) {
		Optional<Estado> obj = estadoRepositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}
	
	public List<Estado> buscarEstadosPorPais(String siglaPais) {
		Pais pais = paisRepositorio.findBySigla(siglaPais);
		if (pais == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Pais: " + pais + ", Tipo: " + Pais.class.getName());
		}
	
		List<Estado> estado = estadoRepositorio.findByPais(pais);
		if (estado == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Pais: " + estado + ", Tipo: " + Estado.class.getName());
		}
		
		return estado;
		
	}

}
