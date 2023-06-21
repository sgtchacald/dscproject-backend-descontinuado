package br.com.diegocordeiro.dscproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="CONTAS")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "AGENCIA", length = 30, nullable = false)
	private String agencia;

	@Column(name = "AGENCIA_DV", length = 30, nullable = false)
	private String agenciaDigito;

	@Column(name = "CONTA", length = 30, nullable = false)
	private String conta;

	@Column(name = "CONTA_DV", length = 30, nullable = false)
	private String contaDigito;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_BANCO")
	private Banco banco;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

}
