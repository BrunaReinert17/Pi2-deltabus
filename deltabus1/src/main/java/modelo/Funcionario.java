package modelo;

import java.time.LocalDate;

public class Funcionario {

	private String nome;

	private LocalDate datanasci;

	private String genero;

	private Long numeroTelefone;

	private String email;

	private Double cpf;

	private Endereco endereco;

	private Usuario usuario;

	public Funcionario(String nome, LocalDate datanasci, String genero, Long numeroTelefone, String email, Double cpf,
			Endereco endereco, Usuario usuario) {

		super();

		this.nome = nome;

		this.datanasci = datanasci;

		this.genero = genero;

		this.numeroTelefone = numeroTelefone;

		this.email = email;

		this.cpf = cpf;

		this.endereco = endereco;

		this.usuario = usuario;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public LocalDate getDatanasci() {

		return datanasci;

	}

	public void setDatanasci(LocalDate datanasci) {

		this.datanasci = datanasci;

	}

	public String getGenero() {

		return genero;

	}

	public void setGenero(String genero) {

		this.genero = genero;

	}

	public Long getNumeroTelefone() {

		return numeroTelefone;

	}

	public void setNumeroTelefone(Long numeroTelefone) {

		this.numeroTelefone = numeroTelefone;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public Double getCpf() {

		return cpf;

	}

	public void setCpf(Double cpf) {

		this.cpf = cpf;

	}

	public Endereco getEndereco() {

		return endereco;

	}

	public void setEndereco(Endereco endereco) {

		this.endereco = endereco;

	}

	public Usuario getUsuario() {

		return usuario;

	}

	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;

	}

}