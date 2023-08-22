package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Cliente;
import modelo.Endereco;

public class ClienteDAO implements InterfaceCliente {

	  private Conexao con;

	    public ClienteDAO() {
	        con = Conexao.getInstacia();
	    }
	
	@Override
	public boolean inserirCliente(Cliente cliente) {
		 Connection c = con.conectar();
	        int valida = 0;

	        try {
	            String query = "INSERT INTO Clientes(Nome, numeroTelefone, email, cnpj, endereco_cep) VALUES (?, ?, ?, ?)";
	            PreparedStatement stm = c.prepareStatement(query);
	            stm.setString(1, cliente.getNome());
	            stm.setInt(2, cliente.getNumeroTelefone());
	            stm.setString(3, cliente.getEmail());
	            stm.setDouble(4,cliente.getCpf());
	            stm.setLong(5, cliente.getCnpj());
	            //stm.setInt(7, cliente.getEndereco().getCep());
	        	
	            valida = stm.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            con.fecharConexao();
	        }
	        return valida != 0;
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
