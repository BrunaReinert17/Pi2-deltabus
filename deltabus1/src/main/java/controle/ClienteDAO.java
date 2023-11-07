package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			PreparedStatement ps = c.prepareStatement("SELECT * FROM Clientes");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cl = new Cliente();
				Endereco endereco = new Endereco();

				cl.setNome(rs.getString("nome"));
				cl.setNumeroTelefone(rs.getString("numeroTelefone"));
				cl.setEmail(rs.getString("email"));
				cl.setCnpj(rs.getLong("Cnpj"));
				cl.setCpf(rs.getString("Cpf"));
				endereco.setCep(rs.getLong("endereco_cep"));

				cl.setEndereco(endereco);
				System.out.println(cl);
				listcliente.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return listcliente;
	}

	public boolean inserirCliente(Cliente cliente) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;

		try {
			String query = "INSERT INTO Clientes(Nome, numeroTelefone, email, cnpj, cpf, endereco_cep) values (?,?,?,?,?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			System.out.println(stm);
			stm.setString(1, cliente.getNome());
			System.out.println(stm);
			stm.setString(2, cliente.getNumeroTelefone());
			System.out.println(stm);
			stm.setString(3, cliente.getEmail());
			System.out.println(stm);
			stm.setLong(4, cliente.getCnpj());
			System.out.println(stm);
			stm.setString(5, cliente.getCpf());
			System.out.println(stm);
			stm.setLong(6, cliente.getEndereco().getCep());
			System.out.println(stm);

			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

	public boolean excluirCliente(Cliente cliente) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM Clientes\r\n  WHERE cnpj = ?";

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

		String query = "UPDATE Clientes\r\n SET" + " nome = ?\r\n" + "numeroTelefone = ?" + " email = ?" + " cpf = ?"
				+ "endereco_cep = ? , WHERE cnpj = ?";
		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getNumeroTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getCpf());
			ps.setLong(5, cliente.getCnpj());
			ps.setLong(6, cliente.getEndereco().getCep());
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

	public static boolean deleteCliente(Cliente cliente) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM Clientes\r\n  WHERE cnpj = ?";

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

	public Cliente selecionarCliente(Cliente clienteModelo) {
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM clientes where cnpj = ?");
			ps.setLong(1, clienteModelo.getCnpj());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("nome");
				String numeroTelefone = rs.getString("numeroTelefone");
				String email = rs.getString("email");
				Long cnpj = rs.getLong("cnpj");
				String cpf = rs.getString("cpf");
				Long enderecoCep = rs.getLong("endereco_cep");

				Endereco endereco = new Endereco();
				endereco.setCep(enderecoCep);

				Cliente cli = new Cliente(nome, numeroTelefone, email, cpf, cnpj, endereco);
				return cli;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return clienteModelo;
	}
}