package modelo;

public class Cliente {

	private String nome;
	private Integer numeroTelefone;
	private Integer Cep;

	private String email;
	private Double Cpf;
	private Long cnpj;
	private Endereco endereco;
	
	
	public Cliente(String nome,Integer numeroTelefone,String email,Double Cpf,Integer cep, Cliente cliente, Double cnpj) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.cliente = cliente;
	}

	private Cliente cliente;
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, Integer numeroTelefone, String email, Double Cpf, Long cnpj,Endereco endereco) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.Cpf = Cpf;
		this.cnpj = cnpj;
		this.endereco = endereco;

	}
	public Integer getCep() {
		return Cep;
	}

	public void setCep(Integer cep) {
		Cep = cep;
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

	public Double getCpf() {
		return Cpf;
	}

	public void setCpf(Double cpf) {
		Cpf = cpf;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
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
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", numeroTelefone=" + numeroTelefone + ", email=" + email + ", Cpf=" + Cpf + "]";
	}

}
