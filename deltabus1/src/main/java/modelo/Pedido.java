package modelo;

import java.time.LocalDate;

public class Pedido extends Veiculo {

	private int id_pedidos;
	private int quantidade;
	private String cliente;
	private LocalDate dataCompra;
	private Double valorPago;
	private String tipoPagamento;
	private String renavam;
	private String nomeCliente;
	

	public Pedido() {
		super();
	}
	
	public Pedido(int id_pedidos,int quantidade, String cliente,LocalDate dataCompra, Double valorPago, String tipoPagamento, String renavam, String nomeCliente) {

		super();
         
		this.id_pedidos = id_pedidos;
		
		this.quantidade = quantidade;

		this.cliente = cliente;

		this.dataCompra = dataCompra;

		this.valorPago = valorPago;

		this.tipoPagamento = tipoPagamento;
		
		this.renavam = renavam;
		
		this.nomeCliente = nomeCliente;
		
		

	}

	public int getId_pedidos() {
		return id_pedidos;
	}

	public void setId_pedidos(int id_pedidos) {
		this.id_pedidos = id_pedidos;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setVeiculo(int veiculo) {
		this.quantidade = quantidade;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
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

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	
}
	
