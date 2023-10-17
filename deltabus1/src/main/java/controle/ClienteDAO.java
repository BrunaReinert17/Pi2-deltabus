package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;
import modelo.Endereco;

public class ClienteDAO implements InterfaceCliente {

	private Conexao con;

	public ClienteDAO() {
		con = Conexao.getInstancia();
	}

	@Override
	public Cliente selecionar(Cliente clienteModelo) {
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM cliente where cnpj = ?");
			ps.setString(1, clienteModelo.getCnpj());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("nome");
				int NumeroTelefone = rs.getInt("numeroTelefone");
				String email = rs.getString("email");
				String PessoaJuridica_ou_Fisica = rs.getString("PessoaJuridica_ou_Fisica");
				int Cep = rs.getInt("endereco_cep");
				Endereco Endereco = rs.getEndereco("endereco");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return null;
	}

	@Override
	public boolean inserirCliente(Cliente cliente) {
		Connection c = con.conectar();
		int valida = 0;

		try {
			String query = "INSERT INTO Clientes(Nome, numeroTelefone, email, PessoaJuridica_ou_Fisica, endereco_cep) VALUES (?, ?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, cliente.getNome());
			stm.setInt(2, cliente.getNumeroTelefone());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getPessoaJuridica_ou_Fisica());
			stm.setInt(5, cliente.getEndereco().getCep());

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

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM Cliente\r\n  WHERE Cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, cliente.getPessoaJuridica_ou_Fisica());
			ps.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public Cliente alterarCliente(Cliente cliente) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

String query = "UPDATE Cliente SET nome = ?, numeroTelefone = ?, email = ?, cnpj = ?, endereco_cep = ? WHERE cpf = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getNumeroTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getPessoaJuridica_ou_Fisica());
			ps.setLong(5, cliente.getEndereco().getCep());

			ps.executeUpdate();

			c.fecharConexao();
			return cliente;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return cliente;
	}


}
