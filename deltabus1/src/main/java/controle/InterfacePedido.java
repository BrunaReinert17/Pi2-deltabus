package controle;

import modelo.Pedido;

public interface InterfacePedido {
     
	public Pedido consultandoPedido(Pedido pedido);

	public boolean inserirPedido(Pedido pedido);

	public boolean excluirPedido(Pedido pedido);

	public boolean alterarPedido(Pedido pedido);
	
	
}
