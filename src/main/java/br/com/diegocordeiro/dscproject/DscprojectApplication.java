package br.com.diegocordeiro.dscproject;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.enums.EstadoCivil;
import br.com.diegocordeiro.dscproject.enums.Genero;
import br.com.diegocordeiro.dscproject.enums.Indicador;
import br.com.diegocordeiro.dscproject.enums.Perfil;
import br.com.diegocordeiro.dscproject.enums.Status;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;

@SpringBootApplication
public class DscprojectApplication  implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(DscprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario();	
		u1.setId(null);
		u1.setTipoPerfil(Perfil.VISITANTE.getCodigo());
		u1.setNome("Diego Dos Santos Cordeiro");
		u1.setCpf("11754423728");
		u1.setDtnascimento(Date.valueOf("1986-07-12"));	
		u1.setEstadoCivil(EstadoCivil.CASADO.getCodigo());
		u1.setGenero(Genero.MASCULINO.getCodigo());
		u1.setIndPortadorDeficiencia(Indicador.NAO.getCodigo());
		u1.setEmail("sgt.chacal.d@gmail.com");
		u1.setIndDisponivelViajar(Indicador.SIM.getCodigo());
		u1.setIndDisponivelMudarCidade(Indicador.NAO.getCodigo());
		u1.setResumoProfissional("Resumo Profissional");
		u1.setUrlBlogSite("http://www.diegocordeiro.com.br");
		u1.setIndStatus(Status.ATIVO.getCodigo());
		u1.setLogin("chacalsgt");
		u1.setSenha("SenhaQueSeráCriptografada");
		
		Usuario u2 = new Usuario();	
		u2.setId(null);
		u2.setTipoPerfil(Perfil.VISITANTE.getCodigo());
		u2.setNome("Clayton Santos Cordeiro");
		u2.setCpf("11754423729");
		u2.setDtnascimento(Date.valueOf("1986-07-12"));	
		u2.setEstadoCivil(EstadoCivil.CASADO.getCodigo());
		u2.setGenero(Genero.MASCULINO.getCodigo());
		u2.setIndPortadorDeficiencia(Indicador.NAO.getCodigo());
		u2.setEmail("claytonsantos13@gmail.com");
		u2.setIndDisponivelViajar(Indicador.SIM.getCodigo());
		u2.setIndDisponivelMudarCidade(Indicador.NAO.getCodigo());
		u2.setResumoProfissional("Resumo Profissional");
		u2.setUrlBlogSite("http://www.diegocordeiro.com.br");
		u2.setIndStatus(Status.ATIVO.getCodigo());
		u2.setLogin("chacalsgt");
		u2.setSenha("SenhaQueSeráCriptografada");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
	}

}
