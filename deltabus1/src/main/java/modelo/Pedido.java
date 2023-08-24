package modelo;

import java.time.LocalDate;

public class Pedido {

	private int veiculo;
	private String cliente;
	private long dataCompra;
	private Double valorPago;
	private String tipoPagamento;

	public Pedido() {
		super();
	}
	
	public Pedido(int veiculo, String cliente, long dataCompra, Double valorPago, String tipoPagamento) {

		super();

		this.veiculo = veiculo;

		this.cliente = cliente;

		this.dataCompra = dataCompra;

		this.valorPago = valorPago;

		this.tipoPagamento = tipoPagamento;

	}

	public int getVeiculo() {

		return veiculo;

	}

	public void setVeiculo(int veiculo) {

		this.veiculo = veiculo;

	}

	public String getCliente() {

		return cliente;

	}

	public void setCliente(String cliente) {

		this.cliente = cliente;

	}

	public long getDataCompra() {

		return dataCompra;

	}

	public void setDataCompra(long dataCompra) {

		this.dataCompra = dataCompra;

	}

	public Double getValorPago() {

		return valorPago;

	}

	public void setValorPago(Double valorPago) {

		this.valorPago = valorPago;

	}

	public String getTipoPagamento() {

		return tipoPagamento;

	}

	public void setTipoPagamento(String tipoPagamento) {

		this.tipoPagamento = tipoPagamento;

	}


}
