package br.com.diegocordeiro.dscproject.dto;

import br.com.diegocordeiro.dscproject.domain.CategoriaLancamento;
import br.com.diegocordeiro.dscproject.enums.TipoPerfil;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarCategoriaLancamento;
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
@ValidarCategoriaLancamento
public class CategoriaLancamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String nome;

	public CategoriaLancamentoDTO(CategoriaLancamento obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
}