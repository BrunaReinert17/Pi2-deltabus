package controle;

import modelo.Cliente;

public interface InterfaceCliente {

	public boolean inserirCliente(Cliente cliente);

	public boolean deletarCliente(Cliente cliente);

	public Cliente alterarCliente(Cliente cliente);

	public Cliente selecionar(Cliente clienteModelo);
}