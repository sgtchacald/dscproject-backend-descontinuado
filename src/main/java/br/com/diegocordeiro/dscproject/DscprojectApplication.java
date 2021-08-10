package br.com.diegocordeiro.dscproject;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.domain.Cidade;
import br.com.diegocordeiro.dscproject.domain.Estado;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.domain.Telefone;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.enums.EstadoCivil;
import br.com.diegocordeiro.dscproject.enums.Genero;
import br.com.diegocordeiro.dscproject.enums.Indicador;
import br.com.diegocordeiro.dscproject.enums.Perfil;
import br.com.diegocordeiro.dscproject.enums.Status;
import br.com.diegocordeiro.dscproject.enums.TipoOperadoraTelefone;
import br.com.diegocordeiro.dscproject.enums.TipoTelefone;
import br.com.diegocordeiro.dscproject.repositories.AtivoRepository;
import br.com.diegocordeiro.dscproject.repositories.CidadeRepository;
import br.com.diegocordeiro.dscproject.repositories.EstadoRepository;
import br.com.diegocordeiro.dscproject.repositories.PaisRepository;
import br.com.diegocordeiro.dscproject.repositories.TelefoneRepository;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;

@SpringBootApplication
public class DscprojectApplication  implements CommandLineRunner{
	
	@Autowired
	private AtivoRepository ativoRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(DscprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		
		//Ativos
		Ativo a1 = new Ativo(null, "Bitcoin", "Criptomoeda Criada por Satoshi para ser descentralizada.");
		Ativo a2 = new Ativo(null, "Ada Cardano", "Criptomoeda Criada para auxiliar a Etiópia a encarar melhores opções financeiras.");
		Ativo a3 = new Ativo(null, "Dogecoin", "Criptomoeda Criada como shitcoin para servir como piada ao bitcoin.");
		
		//Países
		Pais pais1 = new Pais(null, "Brazil","Brasil","BR",123456,"https://www.google.com/url?sa=i&url=https%3A%2F%2Fimagepng.org%2Fbandeira-do-brasil%2F&psig=AOvVaw1pOEOLML5rciUW7cAajGHL&ust=1628223660477000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLjA-fiDmfICFQAAAAAdAAAAABAN");
		Pais pais2 = new Pais(null, "Uruguay", "Uruguai", "UY", 654321, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fpt.wikipedia.org%2Fwiki%2FBandeira_do_Uruguai&psig=AOvVaw1FH2PsKjmhWHuecdg6NZd9&ust=1628223826192000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCU-MeEmfICFQAAAAAdAAAAABAI");
		
		//Estados
		Estado est1 = new Estado(null, "Rio de Janeiro","RJ","000001","21",pais1);
		Estado est2 = new Estado(null, "São Paulo", "SP","000002","11", pais1);
		Estado est3 = new Estado(null, "SCanelones", "CN","000003","85", pais2);
		
		//Cidades
		Cidade cid1 = new Cidade(null, "Bairro Remanso", est3.getIdIBGE(),"85","CN", est3);
		Cidade cid2 = new Cidade(null, "Rio de janeiro", est1.getIdIBGE(),"85","CN", est1);
		Cidade cid3 = new Cidade(null, "Aparecida do Norte", est2.getIdIBGE(),"85","CN", est2);
		
		//Endereco end1 = new Endereco(null,"91180650", Tipo)
		
		//Salvando dados tabelas independentes 
		ativoRepository.saveAll(Arrays.asList(a1,a2,a3));
		paisRepository.saveAll(Arrays.asList(pais1,pais2));
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		//Usuários
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
		//u1.getTelefones().addAll(Arrays.asList(t1, t2));
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
		
		//Telefones
		Telefone t1 = new Telefone(null,TipoOperadoraTelefone.CLARO, TipoTelefone.CELULAR, "21", "994674449", "N", "S", u1);
		Telefone t2 = new Telefone(null,TipoOperadoraTelefone.OI, TipoTelefone.RESIDENCIAL, "51", "27538361", "S", "N", u1);
		
		//Salvando dados do Usuario
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		telefoneRepository.saveAll(Arrays.asList(t1, t2));
		
	}

}
