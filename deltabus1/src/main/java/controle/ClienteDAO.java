package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Cliente;

public class ClienteDAO implements InterfaceCliente {

	private Conexao con;

	public ClienteDAO() {
		con = Conexao.getInstancia();
	}

	@Override
	public Cliente selecionar(Cliente clienteModelo) {
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuario where senha = ? AND email = ?");
			ps.setString(1, clienteModelo.getNome());
			ps.setString(2, clienteModelo.getEmail());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("nome");
				int NumeroTelefone = rs.getInt("numeroTelefone");
				String email = rs.getString("email");
				String PessoaJuridica_ou_Fisica = rs.getString("PessoaJuridica_ou_Fisica");
				int Cep = rs.getInt("endereco_cep");
				// Endereco Endereco = rs.getEndereco("endereco");
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
			stm.setString(2, cliente.getNumeroTelefone());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getPessoaJuridica_ou_Fisica());
			stm.setInt(7, cliente.getEndereco().getCep());

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
