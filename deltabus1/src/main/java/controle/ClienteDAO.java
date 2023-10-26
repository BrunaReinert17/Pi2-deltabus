package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Usuario;

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
				Endereco endereco = new Endereco();
				cl.setNome(rs.getString("nome"));
				cl.setNumeroTelefone(rs.getString("numeroTelefone"));
				cl.setEmail(rs.getString("email"));
				cl.setCnpj(rs.getLong("Cnpj"));
				cl.setCpf(rs.getString("Cpf"));
				endereco.setCep(rs.getInt("endereco_cep"));
			
				cliente.add(cl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return cliente;
	}
	public Cliente selecionarCliente (Cliente clienteModelo) {
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

                Cliente cli = new Cliente(nome, numeroTelefone, email, cpf,cnpj);
                return cli;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return null;
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
			stm.setLong(6, cliente.getEndereco().getCep());
			
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

		String query = "UPDATE Clientes SET" + " nome = ?\r\n" + "numeroTelefone = ?" + " email = ?" + " cpf = ?, WHERE cnpj = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getNumeroTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getCpf());
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
