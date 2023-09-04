package br.com.diegocordeiro.dscproject.dto;

import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.domain.Conta;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarConta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidarConta
public class ContaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotBlank(message="{erro.campo.obrigatorio}")
	@NumberFormat
	private String agencia;
	@NotBlank(message="{erro.campo.obrigatorio}")
	@NumberFormat
	private String agenciaDigito;
	@NotBlank(message="{erro.campo.obrigatorio}")
	@NumberFormat
	private String conta;
	@NotBlank(message="{erro.campo.obrigatorio}")
	@NumberFormat
	private String contaDigito;

	@NotBlank(message="{erro.campo.obrigatorio}")
	@NumberFormat
	private String numeroBanco;

	private Banco banco;

	private Usuario usuario;

	public ContaDTO(Conta obj) {
		this.id = obj.getId();
		this.agencia = obj.getAgencia();
		this.agenciaDigito = obj.getAgenciaDigito();
		this.conta =  obj.getConta();
		this.contaDigito = obj.getContaDigito();
		this.numeroBanco = obj.getBanco().getNumero();
	}

}
