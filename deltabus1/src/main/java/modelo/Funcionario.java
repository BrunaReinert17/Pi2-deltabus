package modelo;

import java.time.LocalDate;

public class Funcionario {

	public static final Funcionario FUNCIONARIEDITADO = null;
	private String nome;
	private LocalDate datanasci;
	private String genero;
	private String numeroTelefone;
	private long cpf;
	private Endereco endereco;
	private Usuario usuario;

	
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, LocalDate datanasci, String genero, String numeroTelefone, long cpf,
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

	public Funcionario(String string, long l, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
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
	public long getCpf() {

		return cpf;

	}

	public void setCpf(long cpf) {

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

	public Funcionario  editarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return funcionario ;
	}

	
}