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
				cl.setNumeroTelefone(rs.getInt("numeroTelefone"));
				cl.setEmail(rs.getString("email"));
				cl.setCpf(rs.getDouble("Cpf"));
				cl.setCep(rs.getInt("endereco_cep"));
				cl.setCnpj(rs.getDouble("Cnpj"));
				cliente.add(cl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.fecharConexao();
		return cliente;
	}

	public boolean inserirCliente(Cliente cliente) {
		Connection c = con.conectar();
		int valida = 0;

		try {
			String query = "INSERT INTO Clientes(Nome, numeroTelefone, email, cnpj, Cpf, endereco_cep) VALUES (?,?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, cliente.getNome());
			if (cliente.getNumeroTelefone() != null) {
	            stm.setInt(2, cliente.getNumeroTelefone());
	        } else {
	            stm.setInt(2, 0);
	        }			stm.setString(3, cliente.getEmail());
			stm.setDouble(4, cliente.getCpf());
			stm.setInt(5, cliente.getCep());
			if (cliente.getCnpj() != null) {
	            stm.setDouble(6, cliente.getCnpj());
	        } else {
	            stm.setDouble(6, 0.0);
	        }
			valida = stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return valida != 0;
	}

	public static boolean excluirCliente(Cliente cliente) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM Clientes\r\n  WHERE cnpj = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, cliente.getCnpj());
			ps.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
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
			ps.setInt(2, cliente.getNumeroTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setDouble(4, cliente.getCpf());
			ps.setLong(5, cliente.getCep());
			ps.setDouble(6, cliente.getCnpj());

			ps.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}
}
