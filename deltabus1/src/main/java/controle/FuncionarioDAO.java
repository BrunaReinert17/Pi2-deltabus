package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import java.time.LocalDate;


public class FuncionarioDAO implements InterfaceFuncionario {

	private static Conexao con;
	
	//seguir como orden

	public boolean inserirFuncionario(Funcionario funcionario) {
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

		return (valida == 0 ? false : true);

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

		String query = "UPDATE Funcionario\r\n   SET" + "nome = ?\r\n" + "dataNascimento = ?" + "genero = ?"
				+ " numerotelefone = ?" + "email = ?" + "Usuario_idUsuario = ?" + "endereco_cep = ? ,  WHERE cpf = ?";
		try {
			PreparedStatement ps = c.prepareStatement(query);

			ps.setString(1, funcionario.getCpf());
			ps.setString(2, funcionario.getNome());
			ps.setDate(3, java.sql.Date.valueOf(funcionario.getDatanasci()));
			ps.setString(4, funcionario.getGenero());
			ps.setString(5, funcionario.getNumeroTelefone());
			ps.setLong(6, funcionario.getUsuario().getIdUsuario());
			ps.setLong(7, funcionario.getEndereco().getCep());
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
			PreparedStatement ps = c.prepareStatement("select * from funcionarios");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();

				

				endereco.setCep(rs.getInt("endereco_cep"));
				usuario.setIdUsuario(rs.getLong("Usuario_idUsuario"));
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

		}  catch (SQLException e) {

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

		}  catch (SQLException e) {

			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return listFunc;
	}

	public static  boolean excluirFuncionario(Funcionario funcionario) {
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