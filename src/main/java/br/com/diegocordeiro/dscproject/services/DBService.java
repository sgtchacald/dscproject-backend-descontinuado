package br.com.diegocordeiro.dscproject.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.domain.Cidade;
import br.com.diegocordeiro.dscproject.domain.Endereco;
import br.com.diegocordeiro.dscproject.domain.Estado;
import br.com.diegocordeiro.dscproject.domain.Investimento;
import br.com.diegocordeiro.dscproject.domain.Operacao;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.domain.Telefone;
import br.com.diegocordeiro.dscproject.domain.TipoInvestimento;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.enums.EstadoCivil;
import br.com.diegocordeiro.dscproject.enums.Genero;
import br.com.diegocordeiro.dscproject.enums.Indicador;
import br.com.diegocordeiro.dscproject.enums.Status;
import br.com.diegocordeiro.dscproject.enums.TipoLogradouro;
import br.com.diegocordeiro.dscproject.enums.TipoOperacao;
import br.com.diegocordeiro.dscproject.enums.TipoOperadoraTelefone;
import br.com.diegocordeiro.dscproject.enums.TipoPerfil;
import br.com.diegocordeiro.dscproject.enums.TipoRenda;
import br.com.diegocordeiro.dscproject.enums.TipoTelefone;
import br.com.diegocordeiro.dscproject.repositories.AtivoRepository;
import br.com.diegocordeiro.dscproject.repositories.CidadeRepository;
import br.com.diegocordeiro.dscproject.repositories.EnderecoRepository;
import br.com.diegocordeiro.dscproject.repositories.EstadoRepository;
import br.com.diegocordeiro.dscproject.repositories.InvestimentoRepository;
import br.com.diegocordeiro.dscproject.repositories.OperacaoRepository;
import br.com.diegocordeiro.dscproject.repositories.PaisRepository;
import br.com.diegocordeiro.dscproject.repositories.TelefoneRepository;
import br.com.diegocordeiro.dscproject.repositories.TipoInvestimentoRepository;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;

@Service
public class DBService {
	@Autowired
	private AtivoRepository ativoRepository;
	@Autowired
	private TipoInvestimentoRepository tipoInvestimentoRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired
	private InvestimentoRepository investimentoRepository;
	@Autowired
	private OperacaoRepository operacaoRepository;
	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public void instantiateDevDatabase(){
		//Tipos de Investimento
		TipoInvestimento tipoInvest1 = new TipoInvestimento(null,"Caderneta de Poupança", "Descrição Caderneta de Poupança.", TipoRenda.RENDA_FIXA);
		TipoInvestimento tipoInvest2 = new TipoInvestimento(null,"CDB", "Descrição CDB.", TipoRenda.RENDA_FIXA);
		TipoInvestimento tipoInvest3 = new TipoInvestimento(null,"LCI/LCA", "Descrição LCI/LCA.", TipoRenda.RENDA_FIXA);
		TipoInvestimento tipoInvest4 = new TipoInvestimento(null,"Tesouro Direto", "Descrição esouro Direto.", TipoRenda.RENDA_FIXA);
		TipoInvestimento tipoInvest5 = new TipoInvestimento(null,"Debêntures", "Descrição Debêntures.", TipoRenda.RENDA_FIXA);
		TipoInvestimento tipoInvest6 = new TipoInvestimento(null,"FII", "Descrição FII.", TipoRenda.RENDA_VARIAVEL);
		TipoInvestimento tipoInvest7 = new TipoInvestimento(null,"Ações nacionais", "Descrição Ações nacionais.", TipoRenda.RENDA_VARIAVEL);
		TipoInvestimento tipoInvest8 = new TipoInvestimento(null,"Ações internacionais", "Descrição Ações internacionais.", TipoRenda.RENDA_VARIAVEL);
		TipoInvestimento tipoInvest9 = new TipoInvestimento(null,"ETF", "Descrição ETF.", TipoRenda.RENDA_VARIAVEL);
		TipoInvestimento tipoInvest10 = new TipoInvestimento(null,"Criptomoedas", "Descrição Criptomoedas.", TipoRenda.RENDA_VARIAVEL);	
		
		//Ativos
		Ativo btc = new Ativo(null, "BTC", "Bitcoin", "Criptomoeda Criada por Satoshi para ser descentralizada.");
		Ativo ada = new Ativo(null, "ADA", "Ada Cardano", "Criptomoeda Criada para auxiliar a Etiópia a encarar melhores opções financeiras.");
		Ativo doge = new Ativo(null, "DOGE", "Dogecoin", "Criptomoeda Criada como shitcoin para servir como piada ao bitcoin.");
		Ativo usdt = new Ativo(null, "USDT", "Thether USD", "Moeda Theter, baseada no dolar americano.");
		
		//Países
		Pais pais1 = new Pais(null, "Brazil","Brasil","BR",123456,"https://www.google.com/url?sa=i&url=https%3A%2F%2Fimagepng.org%2Fbandeira-do-brasil%2F&psig=AOvVaw1pOEOLML5rciUW7cAajGHL&ust=1628223660477000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLjA-fiDmfICFQAAAAAdAAAAABAN");
		Pais pais2 = new Pais(null, "Uruguay", "Uruguai", "UY", 654321, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fpt.wikipedia.org%2Fwiki%2FBandeira_do_Uruguai&psig=AOvVaw1FH2PsKjmhWHuecdg6NZd9&ust=1628223826192000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCU-MeEmfICFQAAAAAdAAAAABAI");
		
		//Estados
		Estado est1 = new Estado(null, "Rio de Janeiro","RJ","000001","21",pais1);
		Estado est2 = new Estado(null, "São Paulo", "SP","000002","11", pais1);
		Estado est3 = new Estado(null, "SCanelones", "CN","000003","85", pais2);
		
		//Cidades
		Cidade cid1 = new Cidade(null, "Bairro Remanso", est3.getIdIBGE(),"85",est3.getUf(), est3);
		Cidade cid2 = new Cidade(null, "Rio de janeiro", est1.getIdIBGE(),"85",est1.getUf(), est1);
		Cidade cid3 = new Cidade(null, "Aparecida do Norte", est2.getIdIBGE(),"85",est2.getUf(), est2);
		Cidade cid4 = new Cidade(null, "Belford Roxo", est1.getIdIBGE(),"21", est1.getUf(), est1);
		
		//Salvando dados tabelas independentes 
		ativoRepository.saveAll(Arrays.asList(btc, ada ,doge, usdt));
		paisRepository.saveAll(Arrays.asList(pais1,pais2));
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));
		tipoInvestimentoRepository.saveAll(Arrays.asList(tipoInvest1, tipoInvest2, tipoInvest3, tipoInvest4, tipoInvest5, tipoInvest6, tipoInvest7, tipoInvest8, tipoInvest9, tipoInvest10));
		
		//Usuários
		Usuario u1 = new Usuario();	
		u1.setId(null);
		u1.addPerfil(TipoPerfil.ADMIN);
		u1.setNome("Diego Dos Santos Cordeiro");
		u1.setCpf("11754423728");
		u1.setDtNascimento(Date.valueOf("1986-07-12"));	
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
		u1.setSenha(passwordEncoder.encode("chacal@01"));
		
		Usuario u2 = new Usuario();	
		u2.setId(null);
		u2.setNome("mcristiane");
		u2.setCpf("16388733050");
		u2.setDtNascimento(Date.valueOf("1986-07-12"));	
		u2.setEstadoCivil(EstadoCivil.CASADO.getCodigo());
		u2.setGenero(Genero.MASCULINO.getCodigo());
		u2.setIndPortadorDeficiencia(Indicador.NAO.getCodigo());
		u2.setEmail("mcristianeterra@gmail.com");
		u2.setIndDisponivelViajar(Indicador.SIM.getCodigo());
		u2.setIndDisponivelMudarCidade(Indicador.NAO.getCodigo());
		u2.setResumoProfissional("Resumo Profissional");
		u2.setUrlBlogSite("http://www.mseso.com.br");
		u2.setIndStatus(Status.ATIVO.getCodigo());
		u2.setLogin("mcristiane");
		u2.setSenha(passwordEncoder.encode("mara@01"));
		
		//Telefones
		Telefone t1 = new Telefone(null,TipoOperadoraTelefone.CLARO, TipoTelefone.CELULAR, "21", "994674449", "N", "S", u1);
		Telefone t2 = new Telefone(null,TipoOperadoraTelefone.OI, TipoTelefone.FIXO, "51", "27538361", "S", "N", u1);
		
		//Endereços
		Endereco end1 = new Endereco(
			null, 
			"91180650", 
			TipoLogradouro.RUA.getDescricao(), 
			"Ferreira de andrade, 136", 
			"Ferreira de andrade", 
			"Bloco 1, Apartamento 404", 
			cid2.getUf(), 
			cid2.getNome(), 
			cid2.getIdIBGE(), 
			"Cachambi", "A",
			cid2, 
			u1
		);
		
		Endereco end2 = new Endereco(
			null, 
			"21965200", 
			TipoLogradouro.AVENIDA.getDescricao(), 
			"Antônio Simões da costa, 22", 
			"Antônio Simões da costa", 
			"Casa 1", 
			cid4.getUf(), 
			cid4.getNome(), 
			cid4.getIdIBGE(), 
			"Jardim Bom Pastor", 
			"A",
			cid4, 
			u2
		);
		
		//Investimentos
		Investimento inv1 = new Investimento(null, new BigDecimal(1000.00), Status.ATIVO.getCodigo(), tipoInvest1, u1);
		Investimento inv2 = new Investimento(null, new BigDecimal(2000.00), Status.ATIVO.getCodigo(), tipoInvest1, u1);
		Investimento inv3 = new Investimento(null, new BigDecimal(3000.00), Status.ATIVO.getCodigo(), tipoInvest1, u1);
		Investimento inv4 = new Investimento(null, new BigDecimal(4000.00), Status.ATIVO.getCodigo(), tipoInvest1, u1);
		Investimento inv5 = new Investimento(null, new BigDecimal(5000.00), Status.ATIVO.getCodigo(), tipoInvest1, u1);
		Investimento inv6 = new Investimento(null, new BigDecimal(6000.00), Status.ATIVO.getCodigo(), tipoInvest10, u1);
		Investimento inv7 = new Investimento(null, new BigDecimal(7000.00), Status.ATIVO.getCodigo(), tipoInvest10, u1);
		Investimento inv8 = new Investimento(null, new BigDecimal(8000.00), Status.ATIVO.getCodigo(), tipoInvest10, u1);
		Investimento inv9 = new Investimento(null, new BigDecimal(9000.00), Status.ATIVO.getCodigo(), tipoInvest10, u1);
		Investimento inv10 = new Investimento(null, new BigDecimal(10000.00), Status.ATIVO.getCodigo(), tipoInvest10, u1);
		Investimento inv11 = new Investimento(null, new BigDecimal(11000.00), Status.ATIVO.getCodigo(), tipoInvest10, u1);
		
		//Salvando dados do Usuario
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		telefoneRepository.saveAll(Arrays.asList(t1, t2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		investimentoRepository.saveAll(Arrays.asList(inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8, inv9, inv10, inv11));
		
		//Operações
		String parBtcUsdt = btc.getCodigo() + usdt.getCodigo();		
		Operacao op1 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op2 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(44802.12), new BigDecimal(0.025859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op3 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(43802.12), new BigDecimal(0.026859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op4 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(42802.12), new BigDecimal(0.027859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op5 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(41802.12), new BigDecimal(0.028859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op6 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(40802.12), new BigDecimal(0.029859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op7 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(39802.12), new BigDecimal(0.030859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op8 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op9 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(44802.12), new BigDecimal(0.025859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op10 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(43802.12), new BigDecimal(0.026859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op11 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(42802.12), new BigDecimal(0.027859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op12 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(41802.12), new BigDecimal(0.028859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op13 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(40802.12), new BigDecimal(0.029859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op14 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(39802.12), new BigDecimal(0.030859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op15 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op16 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(44802.12), new BigDecimal(0.025859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op17 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(43802.12), new BigDecimal(0.026859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op18 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(42802.12), new BigDecimal(0.027859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op19 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(41802.12), new BigDecimal(0.028859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op20 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(40802.12), new BigDecimal(0.029859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op21 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(39802.12), new BigDecimal(0.030859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op22 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op23 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(44802.12), new BigDecimal(0.025859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op24 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(43802.12), new BigDecimal(0.026859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op25 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(42802.12), new BigDecimal(0.027859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op26 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(41802.12), new BigDecimal(0.028859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op27 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(40802.12), new BigDecimal(0.029859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op28 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(39802.12), new BigDecimal(0.030859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op29 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op30 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(44802.12), new BigDecimal(0.025859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op31 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(43802.12), new BigDecimal(0.026859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op32 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(42802.12), new BigDecimal(0.027859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op33 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(41802.12), new BigDecimal(0.028859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op34 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(40802.12), new BigDecimal(0.029859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op35 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(39802.12), new BigDecimal(0.030859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op36 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op37 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(44802.12), new BigDecimal(0.025859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op38 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(43802.12), new BigDecimal(0.026859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op39 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(42802.12), new BigDecimal(0.027859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op40 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(41802.12), new BigDecimal(0.028859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op41 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(40802.12), new BigDecimal(0.029859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op42 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(39802.12), new BigDecimal(0.030859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op43 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op44 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(44802.12), new BigDecimal(0.025859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op45 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(43802.12), new BigDecimal(0.026859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op46 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(42802.12), new BigDecimal(0.027859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op47 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(41802.12), new BigDecimal(0.028859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op48 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.VENDA ,  new BigDecimal(40802.12), new BigDecimal(0.029859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op49 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(39802.12), new BigDecimal(0.030859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		Operacao op50 = new Operacao(null, Date.valueOf("2021-08-11"), parBtcUsdt, TipoOperacao.COMPRA , new BigDecimal(45802.12), new BigDecimal(0.021859), new BigDecimal(1001.108), new BigDecimal(1.00118854), u1, btc);
		
		operacaoRepository.saveAll(Arrays.asList(
			op1,  op2,  op3,  op4,  op5,  op6,  op7,  op8,  op9, op10, 
			op11, op12, op13, op14, op15, op16, op17, op18, op19, op20,
			op21, op22, op23, op24, op25, op26, op27, op28, op29, op30,
			op31, op32, op33, op34, op35, op36, op37, op38, op39, op40,
			op41, op42, op43, op44, op45, op46, op47, op48, op49, op50)
		);
	}

}
