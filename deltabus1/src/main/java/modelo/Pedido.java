package modelo;

import java.time.LocalDate;

public class Pedido {

private Veiculo veiculo;

private Cliente cliente;

private LocalDate dataCompra;

private Double valorPago;

private String tipoPagamento;

public Pedido(Veiculo veiculo, Cliente cliente, LocalDate dataCompra, Double valorPago, String tipoPagamento ) {

super();

this.veiculo = veiculo;

this.cliente = cliente;

this.dataCompra = dataCompra;

this.valorPago = valorPago;

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

}


