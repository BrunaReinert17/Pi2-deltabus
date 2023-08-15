package modelo;

public class Endereco {

	private long cep;
	private String cidade;
	private String bairro;
	private String rua;
	private String estado;
	private String Uf;
	
	
	public Endereco(long cep, String cidade,String bairro,String rua, String estado, String UF) {
		super();
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.estado = estado;
		this.Uf = UF;
	}
}
