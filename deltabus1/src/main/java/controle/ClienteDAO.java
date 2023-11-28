package controle;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Endereco;

public class ClienteDAO implements InterfaceCliente {

	private static Conexao con;

	public static ArrayList<Cliente> listar() {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		ArrayList<Cliente> listcliente = new ArrayList<Cliente>();

		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM clientes");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cl = new Cliente();
				Endereco endereco = new Endereco();

				cl.setNome(rs.getString("Nome"));
				cl.setNumeroTelefone(rs.getString("numeroTelefone"));
				cl.setEmail(rs.getString("email"));
				cl.setCnpj(rs.getLong("cnpj"));

				EnderecoDAO endeDao = new EnderecoDAO();

				endereco.setCep(rs.getInt("endereco_cep"));
				endereco = endeDao.listandoEndereco(endereco);
				cl.setEndereco(endereco);
				listcliente.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return listcliente;

	}

	public Cliente selecionarCliente(Cliente clienteModelo) {
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM clientes where cnpj = ?");
			ps.setLong(1, clienteModelo.getCnpj());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("Nome");
				String numeroTelefone = rs.getString("numeroTelefone");
				String email = rs.getString("email");
				Long cnpj = rs.getLong("cnpj");
				Long enderecoCep = rs.getLong("endereco_cep");

				Endereco endereco = new Endereco();
				endereco.setCep(enderecoCep);
				Cliente cli = new Cliente(nome, numeroTelefone, email, cnpj, endereco);
				return cli;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return clienteModelo;
	}

	public boolean inserirCliente(Cliente cliente) {
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		int valida = 0;


			try {
				String query = "INSERT INTO clientes(Nome, numeroTelefone, email, cnpj, endereco_cep) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setString(1, cliente.getNome());
				stm.setString(2, cliente.getNumeroTelefone());
				stm.setString(3, cliente.getEmail());
				stm.setLong(4, cliente.getCnpj());
				stm.setLong(5, cliente.getEndereco().getCep());

				PreparedStatement ps = c.prepareStatement(query);

				valida = stm.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}
		
			return (valida == 0 ? false : true);
	}

	public boolean excluirCliente(Cliente cliente) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM clientes\r\n  WHERE cnpj = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setLong(1, cliente.getCnpj());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public boolean alterarCliente(Cliente cliente) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE clientes SET" + " Nome = ?," + "numeroTelefone = ?," + " email = ?,"
				+ "endereco_cep = ?  WHERE cnpj = ?";
		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getNumeroTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setLong(4, cliente.getEndereco().getCep());
			ps.setLong(5, cliente.getCnpj());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return true;
	}

	public static boolean deleteCliente(Cliente cliente) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM clientes  WHERE cnpj = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setLong(1, cliente.getCnpj());
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

}