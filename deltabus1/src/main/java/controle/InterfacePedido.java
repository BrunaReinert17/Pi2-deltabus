package controle;

import modelo.Pedido;

public interface InterfacePedido {
    

	public boolean inserirPedido(Pedido pedido);

	public boolean excluirPedido(Pedido pedido);

	public boolean alterarPedido(Pedido pedido);
	
	
}