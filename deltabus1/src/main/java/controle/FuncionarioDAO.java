package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;

public class FuncionarioDAO implements InterfaceFuncionario {

	private static Conexao con;

	// seguir como orden

	public long inserirFuncionario(Funcionario funcionario) {
		System.out.println(funcionario.toString());

		con = Conexao.getInstancia();

		Connection c = con.conectar();

		int valida = 0;

		try {
			String query = "INSERT INTO Funcionarios (cpf, nome, dataNascimento, genero, numerotelefone,Usuario_idUsuario,endereco_cep, email)values(?,?,?,?,?,?,?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			System.out.println(stm);
			stm.setString(1, funcionario.getCpf());
			stm.setString(2, funcionario.getNome());
			System.out.println(stm);
			stm.setDate(3, java.sql.Date.valueOf(funcionario.getDatanasci()));
			stm.setString(4, funcionario.getGenero());
			stm.setString(5, funcionario.getNumeroTelefone());
			System.out.println(stm);
			stm.setLong(6, funcionario.getUsuario().getIdUsuario());
			stm.setLong(7, funcionario.getEndereco().getCep());
			stm.setString(8, funcionario.getEmail());

			System.out.println(stm);
			valida = stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return valida;

	}

	public boolean deletarFuncionario(Funcionario funcionario) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM funcionarios\r\n  WHERE cpf = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, funcionario.getCpf());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}
		return false;
	}

	@Override
	public boolean alterarFuncionario(Funcionario funcionario) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE funcionarios   SET " + "nome = ?, " + "dataNascimento = ?, " + "genero = ?, "
				+ " numerotelefone = ?, " + "email = ?, " + "Usuario_idUsuario = ?, "
				+ "endereco_cep = ?   WHERE cpf = ?";
		try {
			PreparedStatement ps = c.prepareStatement(query);

			ps.setString(1, funcionario.getNome());
			ps.setDate(2, java.sql.Date.valueOf(funcionario.getDatanasci()));
			ps.setString(3, funcionario.getGenero());
			ps.setString(4, funcionario.getNumeroTelefone());
			ps.setString(5, funcionario.getEmail());
			ps.setLong(6, funcionario.getUsuario().getIdUsuario());
			ps.setLong(7, funcionario.getEndereco().getCep());
			ps.setString(8, funcionario.getCpf());

			System.out.println(ps);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return true;
	}

	public ArrayList<Funcionario> consultarTodos() {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		ArrayList<Funcionario> listFunc = new ArrayList<Funcionario>();
		try {
			PreparedStatement ps = c.prepareStatement(
					"select * from funcionarios join usuario u on u.idUsuario = funcionarios.Usuario_idUsuario join endereco on funcionarios.endereco_cep=endereco.cep");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();

				endereco.setCep(rs.getInt("endereco_cep"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setRua(rs.getString("rua"));
				endereco.setUf(rs.getString("UF"));

				usuario.setIdUsuario(rs.getLong("Usuario_idUsuario"));
				usuario.setCargo(rs.getString("cargo"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));

				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setGenero(rs.getString("genero"));
				funcionario.setNumeroTelefone(rs.getString("numerotelefone"));
				funcionario.setDatanasci(rs.getDate("dataNascimento").toLocalDate());

				funcionario.setUsuario(usuario);
				funcionario.setEndereco(endereco);
				System.out.println(funcionario);
				listFunc.add(funcionario);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return listFunc;
	}

	public static ArrayList<Funcionario> Pesquisar(String cpf) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		ArrayList<Funcionario> listFunc = new ArrayList<Funcionario>();
		try {
			PreparedStatement ps = c.prepareStatement("select * from funcionarios  WHERE cpf = ?");
			ps.setString(1, "%" + cpf + "%");
			ps.setString(2, "%" + cpf + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();

				endereco.setCep(rs.getInt("endereco_cep"));
				usuario.setIdUsuario(rs.getLong("Usuario_idUsuario"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setGenero(rs.getString("genero"));
				funcionario.setNumeroTelefone(rs.getString("numerotelefone"));
				funcionario.setDatanasci(rs.getDate("dataNascimento").toLocalDate());

				funcionario.setUsuario(usuario);
				funcionario.setEndereco(endereco);
				System.out.println(funcionario);
				listFunc.add(funcionario);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return listFunc;
	}

	public static boolean excluirFuncionario(Funcionario funcionario) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM funcionarios\r\n  WHERE cpf = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, funcionario.getCpf());
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