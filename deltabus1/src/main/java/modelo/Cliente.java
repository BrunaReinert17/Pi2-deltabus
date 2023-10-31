 package modelo;

public class Cliente  {
	
	private String nome;
	private int numeroTelefone;
	private String email;
	private Double Cpf;
	private Integer Cep;
	private Cliente cliente;
	private String cnpj;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome,int numeroTelefone,String email,Double Cpf,Integer cep, Cliente cliente, String cnpj) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.Cpf = Cpf;;
		this.Cep = cep;
		this.cliente = cliente;
		this.cnpj = cnpj;
		
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

	public Double getCpf() {

		return Cpf;

	}

	public void setCpf(Double Cpf) {

		this.Cpf = Cpf;

	}

	public Integer getCep() {
		return Cep;
	}

	public void setCep(Integer cep) {
		this.Cep = cep;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {

	this.cnpj = cnpj;

	}
	
	public String toString() {
		return "Cliente [nome=" + nome +", numeroTelefone=" + numeroTelefone + ", email=" + email + ", Cpf=" + Cpf +",cep=" + Cep + ", cliente=" + cliente + "]";
	}

}
