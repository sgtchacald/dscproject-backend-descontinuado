package br.com.diegocordeiro.dscproject.dto;

import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String agencia;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String agenciaDigito;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String conta;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String contaDigito;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private Banco banco;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private Usuario usuario;

}
