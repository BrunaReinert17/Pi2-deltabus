package modelo;

public class Cliente  {
	
	private String nome;
	private int numeroTelefone;
	private String email;
	private double cpf;
	private long cnpj;
	private Endereco endereco;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome,int numeroTelefone,String email,double cpf,long cnpj,Endereco endereco) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCpf() {
		return cpf;
	}

	public void setCpf(double cpf) {
		this.cpf = cpf;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
