package modelo;

public class Cliente {

	private String nome;
	private String numeroTelefone;
	private String email;
	private String Cpf;
	private Long Cep;
	private Long cnpj;
	private Endereco endereco;
	

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

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
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

	public Long getCep() {
		return Cep;
	}

	public void setCep(Long cep) {
		Cep = cep;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Cliente(String nome, String numeroTelefone, String email, String Cpf, Long cep, Long cnpj) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.Cpf = Cpf;
		this.Cep = cep;
		this.cnpj = cnpj;

	}

	public String toString() {
		return "Cliente [nome=" + nome + ", numeroTelefone=" + numeroTelefone + ", email=" + email + ", Cpf=" + Cpf
				+ ",cep=" + Cep + "]";
	}

}
