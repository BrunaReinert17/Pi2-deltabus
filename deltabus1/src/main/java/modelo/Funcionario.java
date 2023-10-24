package modelo;

import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private String email;
	


	private LocalDate datanasci;
	private String genero;
	private String numeroTelefone;
	private Double cpf;
	private Endereco endereco;
	private Usuario usuario;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, LocalDate datanasci, String genero, String numeroTelefone, Double cpf,
			Endereco endereco, Usuario usuario) {
		super();
		this.nome = nome;
		this.datanasci = datanasci;
		this.genero = genero;
		this.numeroTelefone = numeroTelefone;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
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

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
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

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", datanasci=" + datanasci + ", genero=" + genero + ", numeroTelefone="
				+ numeroTelefone + ", cpf=" + cpf + ", endereco=" + endereco + ", usuario=" + usuario + "]";
	}

<<<<<<< Updated upstream

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	
=======
>>>>>>> Stashed changes
}