package modelo;

import java.time.LocalDate;

public class Funcionario {

	public static final Funcionario FUNCIONARIEDITADO = null;
	private String nome;
	private LocalDate datanasci;
	private String genero;
	private String numeroTelefone;
	private String cpf;
	private Endereco endereco;
	private Usuario usuario;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, LocalDate datanasci, String genero, String numeroTelefone, String cpf,
			Endereco endereco, Usuario usuario) {

		super();

		this.nome = nome;

		this.datanasci = datanasci;

		this.genero = genero;

		this.numeroTelefone = numeroTelefone;

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

	public String getCpf() {

		return cpf;

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

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", datanasci=" + datanasci + ", genero=" + genero + ", numeroTelefone="
				+ numeroTelefone + ", cpf=" + cpf + ", endereco=" + endereco + ", usuario=" + usuario + "]";
	}

	public Funcionario editarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return funcionario;
	}

	public void setUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	public void setUsuario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	public void setCpf(String cpf) {
		// TODO Auto-generated method stub

	}

	public void setCpf(int i) {
		// TODO Auto-generated method stub

	}

}