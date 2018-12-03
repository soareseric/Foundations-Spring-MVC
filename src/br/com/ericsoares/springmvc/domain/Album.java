package br.com.ericsoares.springmvc.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Album {

	@NotNull(message="O nome é obrigatório")
	@NotEmpty(message="O nome é obrigatório")
	@Size(min = 4, max = 10, message="O nome deve conter ao menos 4 caracteres e no maximo 10")
	private String nome;

	@NotNull
	@Min(value = 1990, message= "O ano de lancamento deve ser apartir de 1990")
	@Max(value = 2030, message= "O ano de lancamento deve ser até 2030")
	private int anoDeLancamento;
	
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
