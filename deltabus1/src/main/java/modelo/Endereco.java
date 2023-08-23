package modelo;

public class Endereco {

	private int cep;
	private String cidade;
	private String bairro;
	private String rua;
	private String estado;
	private String Uf;
	
	
	public Endereco() {
		super();
	}
	public Endereco(int cep, String cidade,String bairro,String rua, String estado, String UF) {
		super();
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.estado = estado;
		this.Uf = UF;
		
	}


	public long getCep() {
		return cep;
	}


	public void setCep(int cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getUf() {
		return Uf;
	}


	public void setUf(String uf) {
		Uf = uf;
	}
}
