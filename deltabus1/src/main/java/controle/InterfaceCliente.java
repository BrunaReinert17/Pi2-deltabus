package controle;

import modelo.Cliente;

public interface InterfaceCliente {

	public boolean inserirCliente(Cliente cliente);

	public boolean excluirCliente(Cliente cliente);

	public boolean alterarCliente(Cliente cliente);

}