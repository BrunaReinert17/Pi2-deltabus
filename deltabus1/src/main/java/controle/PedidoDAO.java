package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Cliente;

public class PedidoDAO implements InterfaceCliente{
   
	 private Conexao con;
	 
	 public PedidoDAO() {
	        con = Conexao.getInstacia();
	    }

	@Override
	public boolean inserirCliente(Cliente cliente) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		int valida = 0;
		return false;
	}

	@Override
	public boolean deletarCliente(Cliente cliente) {
		
		return false;
	}

	@Override
	public Cliente alterarCliente(Cliente cliente) {
		
		return null;
	}
	 
	 
	
}
