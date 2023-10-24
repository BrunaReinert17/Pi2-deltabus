package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteDAO {

	private Conexao con;

	public ClienteDAO() {
	
		con = Conexao.getInstancia();
	}

	public ArrayList<Cliente> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Cliente> cliente = new ArrayList<>();

		String query = "SELECT * FROM Clientes";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cl = new Cliente();
				cl.setNome(rs.getString("nome"));
				cl.setNumeroTelefone(rs.getString("numeroTelefone"));
				cl.setEmail(rs.getString("email"));
				cl.setCnpj(rs.getLong("Cnpj"));
				cl.setCpf(rs.getString("Cpf"));
				cl.setCep(rs.getLong("endereco_cep"));
			
				cliente.add(cl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return cliente;
	}

	public boolean inserirCliente(Cliente cliente) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		int valida = 0;

		try {
			String query = "INSERT INTO Clientes(Nome, numeroTelefone, email, cnpj, cpf, endereco_cep) VALUES (?,?,?,?,?,?)";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getNumeroTelefone());
			stm.setString(3, cliente.getEmail());
			stm.setLong(4, cliente.getCnpj());
			stm.setString(5, cliente.getCpf());
			stm.setLong(6, cliente.getCep());
			
			System.out.println(stm);
			valida = stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return valida != 0;
	}

	public static boolean excluirCliente(Cliente cliente) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM Clientes\r\n  WHERE cnpj = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, cliente.getCnpj());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return false;
	}

	public boolean alterarCliente(Cliente cliente) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE Clientes SET" + " nome = ?\r\n" + "numeroTelefone = ?" + " email = ?" + " cpf = ?"
				+ " endereco_cep = ?, WHERE cnpj = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getNumeroTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getCpf());
			ps.setDouble(5, cliente.getCep());
			ps.setLong(6, cliente.getCnpj());

			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}
}
