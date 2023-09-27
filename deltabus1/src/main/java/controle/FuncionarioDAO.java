package controle;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;

public class FuncionarioDAO implements InterfaceFuncionario {

	private static Conexao con;
	private static ArrayList<Funcionario> listaFuncionario;

	private static FuncionarioDAO funcionarioDao;


	
	public boolean inserirFuncionario(Funcionario funcionario) {
		System.out.println(funcionario.toString());
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		int valida = 0;
		try {
			String query = "INSERT INTO Funcionarios (cpf, nome, dataNascimento, genero, numerotelefone,Usuario_idUsuario,endereco_cep)values(?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, funcionario.getCpf());
			stm.setString(2, funcionario.getNome());
			stm.setDate(3, java.sql.Date.valueOf(funcionario.getDatanasci()));
			stm.setString(4, funcionario.getGenero());
			stm.setString(5, funcionario.getNumeroTelefone());
			stm.setLong(6, funcionario.getUsuario().getIdUsuario());
			stm.setLong(7, funcionario.getEndereco().getCep());

			valida = stm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			return (valida == 0 ? false : true);
		}

	}

	@Override
	public boolean deletarFuncionario(Funcionario funcionario) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM funcionarios\r\n  WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, funcionario.getCpf());
			ps.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean alterarFuncionario(Funcionario funcionario) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE Funcionario\r\n   SET" + "nome = ?\r\n" + "dataNascimento = ?" + "genero = ?"
				+ " numerotelefone = ?" + "email = ?" + "Usuario_idUsuario = ?" + "endereco_cep = ? ,  WHERE cpf = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, funcionario.getCpf());
			ps.setString(2, funcionario.getNome());
			ps.setDate(3, java.sql.Date.valueOf(funcionario.getDatanasci()));
			ps.setString(4, funcionario.getGenero());
			ps.setString(5, funcionario.getNumeroTelefone());
			ps.setLong(6, funcionario.getUsuario().getIdUsuario());
			ps.setLong(7, funcionario.getEndereco().getCep());
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

	public  ArrayList<Funcionario> consultarTodos() {
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

				System.out.println("e");

				endereco.setCep(rs.getInt("endereco_cep"));
				usuario.setIdUsuario(rs.getLong("Usuario_idUsuario"));
				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setGenero(rs.getString("genero"));
				funcionario.setNumeroTelefone(rs.getString("numerotelefone"));
				funcionario.setDatanasci(rs.getDate("dataNascimento").toLocalDate());

				funcionario.setUsuario(usuario);
				funcionario.setEndereco(endereco);
				System.out.println(funcionario);
				listFunc.add(funcionario);
			}
		} catch (Exception e) {

		}
		return listFunc;
	}
	
	public static  ArrayList<Funcionario> Pesquisar(Long cpf) {
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

				System.out.println("e");

				endereco.setCep(rs.getInt("endereco_cep"));
				usuario.setIdUsuario(rs.getLong("Usuario_idUsuario"));
				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setGenero(rs.getString("genero"));
				funcionario.setNumeroTelefone(rs.getString("numerotelefone"));
				funcionario.setDatanasci(rs.getDate("dataNascimento").toLocalDate());

				funcionario.setUsuario(usuario);
				funcionario.setEndereco(endereco);
				System.out.println(funcionario);
				listFunc.add(funcionario);
			}
		} catch (Exception e) {

		}
		return listFunc;
	}
}