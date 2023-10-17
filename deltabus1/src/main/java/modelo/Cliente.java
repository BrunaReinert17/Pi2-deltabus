package modelo;

public class Cliente  {
	
	private String nome;
	private int numeroTelefone;
	private String email;
	private String PessoaJuridica_ou_Fisica;
	private Endereco endereco;
	private Cliente cliente;
	private int cnpj;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome,int numeroTelefone,String email,String PessoaJuridica_ou_Fisica,Endereco endereco, Cliente cliente) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.PessoaJuridica_ou_Fisica = PessoaJuridica_ou_Fisica;;
		this.endereco = endereco;
		this.cliente = cliente;
		
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

	public String getPessoaJuridica_ou_Fisica() {

		return PessoaJuridica_ou_Fisica;

	}

	public void setPessoaJuridica_ou_Fisica(String PessoaJuridica_ou_Fisica) {

		this.PessoaJuridica_ou_Fisica = PessoaJuridica_ou_Fisica;

	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCnpj() {
		return null;
	}
	public void setCnpj(String cnpj) {

	//	this.cnpj = cnpj;

	}
	
	public String toString() {
		return "Cliente [nome=" + nome +", numeroTelefone=" + numeroTelefone + ", email=" + email + ", PessoaJuridica_ou_Fisica=" + PessoaJuridica_ou_Fisica +",endereco=" + endereco + ", cliente=" + cliente + "]";
	}

	


	
}
