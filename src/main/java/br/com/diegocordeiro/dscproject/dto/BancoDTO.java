package br.com.diegocordeiro.dscproject.dto;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.domain.CategoriaLancamento;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarBanco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidarBanco
public class BancoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String numero;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String nome;

	public BancoDTO(Banco obj) {
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.nome = obj.getNome();
	}
}