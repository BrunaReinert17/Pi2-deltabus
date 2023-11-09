package modelo;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;

public class Pedido extends Veiculo {

	private int id_pedidos;
	private int quantidade;
	private LocalDate dataCompra;
	private double valorPago;
	private FormaPagamento tipoPagamento;
	private Veiculo veiculo;
	private Cliente cliente;
	

	public Pedido() {
		super();
	}
	
	public Pedido(int id_pedidos,int quantidade, LocalDate dataCompra, Double valorPago, FormaPagamento tipoPagamento, Veiculo veiculo, Cliente cliente) {
		super();
       
		this.id_pedidos = id_pedidos;
		this.quantidade = quantidade;
		this.dataCompra = dataCompra;
		this.valorPago = valorPago;
		this.tipoPagamento = tipoPagamento;		
		this.veiculo = veiculo;		
		this.cliente = cliente;
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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
	