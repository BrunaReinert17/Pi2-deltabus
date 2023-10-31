package modelo;

public class Cliente {

	private String nome;
	private Integer numeroTelefone;
	private String email;
	private String Cpf;
	private Long cnpj;
	private Endereco endereco;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Cliente(String nome,Integer numeroTelefone,String email,Double Cpf,Integer cep, Cliente cliente, Double cnpj) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.Cpf = Cpf;;
		this.Cep = cep;
		this.cliente = cliente;
	}

	private Cliente cliente;

	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Integer numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}


	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Cliente(String nome, String numeroTelefone, String email, String Cpf, Long cnpj) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.Cpf = Cpf;
		this.cnpj = cnpj;

	}

	public String toString() {
		return "Cliente [nome=" + nome + ", numeroTelefone=" + numeroTelefone + ", email=" + email + ", Cpf=" + Cpf + "]";
	}

}
