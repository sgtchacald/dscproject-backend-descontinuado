package br.com.diegocordeiro.dscproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="BANCOS")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Banco implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "NUMERO", length = 50, nullable = false)
	private String numero;

	@Column(name = "NOME", length = 30, nullable = false)
	private String nome;
}
