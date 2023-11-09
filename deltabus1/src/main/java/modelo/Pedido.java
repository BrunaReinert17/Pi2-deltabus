package modelo;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;

public class Pedido extends Veiculo {

	private int id_pedidos;
	private int quantidade;
	private String cnpj;
	private LocalDate dataCompra;
	private double valorPago;
	private FormaPagamento tipoPagamento;
	private String renavam;
	private String nomeCliente;
	

	public Pedido() {
		super();
	}
	
	public Pedido(int id_pedidos,int quantidade, String cnpj,LocalDate dataCompra, Double valorPago, FormaPagamento tipoPagamento, String renavam, String nomeCliente) {
		super();
       
		this.id_pedidos = id_pedidos;
		this.quantidade = quantidade;
		this.cnpj = cnpj;
		this.dataCompra = dataCompra;
		this.valorPago = valorPago;
		this.tipoPagamento = tipoPagamento;		
		this.renavam = renavam;		
		this.nomeCliente = nomeCliente;
		}

	public int getId_pedido() {
		return id_pedidos;
	}

	public void setId_pedido(int id_pedidos) {
		this.id_pedidos = id_pedidos;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public FormaPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(FormaPagamento tipoPagamento) {
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
	