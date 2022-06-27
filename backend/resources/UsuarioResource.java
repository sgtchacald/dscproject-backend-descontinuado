package br.com.diegocordeiro.dscproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> listar() {
		
		Usuario u1 = new Usuario(1, "Diego", "sgt.chacal.d@gmail.com", "dcordeiro", "d123b");
		Usuario u2 = new Usuario(2, "Lucas", "lmarques@gmail.com", "lukasmarques", "c123d");
		
		List<Usuario> lista = new ArrayList<>();
		
		lista.add(u1);
		lista.add(u2);
		
		return lista;
		
	}

}
