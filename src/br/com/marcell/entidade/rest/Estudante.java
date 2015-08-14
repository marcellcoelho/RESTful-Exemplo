package br.com.marcell.entidade.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Estudante implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String sobrenome;
	private int idade;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", sobrenome="+ sobrenome + ", idade=" + idade + "]";
	}

}