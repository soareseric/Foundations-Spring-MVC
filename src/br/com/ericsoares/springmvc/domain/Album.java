package br.com.ericsoares.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alb_albuns")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alb_id")
	private Long id;

	@NotNull(message="O nome é obrigatório")
	@NotEmpty(message="O nome é obrigatório")
	@Size(min = 4, max = 10, message="O nome deve conter ao menos 4 caracteres e no maximo 10")
	@Column(name = "alb_nome", length = 10, nullable = false)
	private String nome;

	@NotNull
	@Min(value = 1990, message= "O ano de lancamento deve ser apartir de 1990")
	@Max(value = 2030, message= "O ano de lancamento deve ser até 2030")
	@Column(name = "alb_ano_lancamento", nullable = false)
	private int anoDeLancamento;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}
	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	
}
