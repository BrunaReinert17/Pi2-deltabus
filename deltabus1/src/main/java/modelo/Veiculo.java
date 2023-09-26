package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Veiculo {

	private Long idVeiculo;
	private String marca;
	private String modelo;
	private Double preco;
	private Date ano;
	private String acessorios;
	private int lotacao;
	private String placa;
	private String renavam;
	private String cor;
	private String TipoFrota;
	private int Kmveiculo;
	private String TipoCombustivel;
	private boolean situacao;
	
	public Veiculo() {
		super();
	}
	
	public Veiculo(Long idVeiculo, String marca, String modelo, Double preco, Date ano, String acessorios,
			int lotacao, String placa, String renavam, String cor, String TipoFrota, int Kmveiculo,
			String TipoCombustivel, boolean situacao) {

		super();

		this.idVeiculo = idVeiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
		this.ano = ano;
		this.acessorios = acessorios;
		this.lotacao = lotacao;
		this.placa = placa;
		this.renavam = renavam;
		this.cor = cor;
		this.TipoFrota = TipoFrota;
		this.Kmveiculo = Kmveiculo;
		this.TipoCombustivel = TipoCombustivel;
		this.situacao = situacao;

	}

	public Long getIdVeiculo() {

		return idVeiculo;

	}

	public void setIdVeiculo(Long idVeiculo) {

		this.idVeiculo = idVeiculo;

	}

	public String getMarca() {

		return marca;

	}

	public void setMarca(String marca) {

		this.marca = marca;

	}

	public String getModelo() {

		return modelo;

	}

	public void setModelo(String modelo) {

		this.modelo = modelo;

	}

	public Double getPreco() {

		return preco;

	}

	public void setPreco(Double preco) {

		this.preco = preco;

	}

	public Date getAno() {

		return ano;

	}

	public void setAno(Date date) {

		this.ano = date;

	}

	public String getAcessorios() {

		return acessorios;

	}

	public void setAcessorios(String acessorios) {

		this.acessorios = acessorios;

	}

	public int getLotacao() {

		return lotacao;

	}

    public void setLotacao(int lotacao) {

		this.lotacao = lotacao;

	}

	public String getPlaca() {

		return placa;

	}

	public void setPlaca(String placa) {

		this.placa = placa;

	}

	public String getRenavam() {

		return renavam;

	}

	public void setRenavam(String renavam) {

		this.renavam = renavam;

	}

	public String getCor() {

		return cor;

	}

	public void setCor(String cor) {

		this.cor = cor;

	}

	public String getTipoFrota() {

		return TipoFrota;

	}

	public void setTipoFrota(String tipoFrota) {

		TipoFrota = tipoFrota;

	}

	public int getKmveiculo() {

		return Kmveiculo;

	}

	public void setKmveiculo(int kmveiculo) {

		Kmveiculo = kmveiculo;

	}

	public String getTipoCombustivel() {

		return TipoCombustivel;

	}

	public void setTipoCombustivel(String tipoCombustivel) {

		TipoCombustivel = tipoCombustivel;

	}

	public boolean isSituacao() {

		return situacao;

	}

	public void setSituacao(boolean situacao) {

		this.situacao = situacao;

	}

}
