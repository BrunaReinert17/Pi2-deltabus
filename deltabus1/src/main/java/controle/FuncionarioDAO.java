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

	private Conexao con;
	private static ArrayList<Funcionario> listaFuncionario;

	private static FuncionarioDAO funcionarioDao;

	public static void getIntancia() {
		if (funcionarioDao == null) {
			funcionarioDao = new FuncionarioDAO();
			listaFuncionario = new ArrayList<Funcionario>();

			listaFuncionario.add(new Funcionario("Bruna", 14058567937l, "bruna@gmail.com", "secretaria", "bruna18"));
			listaFuncionario.add(new Funcionario("agatha", 123456789101l, "agatha@gmail.com", "vice secretaria", "agatha12"));
			listaFuncionario.add(new Funcionario("Maria Tereza", 123456789101l, "maria@gmail.com", "gerente", "maria05"));
			listaFuncionario.add(new Funcionario("Aguida", 123456789101l, "aguida@gmail.com", "vice gerente", "aguida123"));
		}

	}

	@Override
	public boolean inserirFuncionario(Funcionario funcionario) {
		System.out.println(funcionario.toString());
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		int valida = 0;
		try {
			String query = "INSERT INTO Funcionarios (cpf, nome, dataNascimento, genero, numerotelefone,Usuario_idUsuario,endereco_cep)values(?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setDouble(1, funcionario.getCpf());

			stm.setString(2, funcionario.getNome());
			stm.setDate(3, java.sql.Date.valueOf(funcionario.getDatanasci()));
			stm.setString(4, funcionario.getGenero());
			//stm.setString(5, funcionario.getNumeroTelefone());
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
		return false;
	}

	@Override
	public Funcionario alterarFuncionario(Funcionario funcionario) {
		return null;
	}

	public ArrayList<Funcionario> consultarTodos() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		ArrayList<Funcionario> listFunc = new ArrayList<>();
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
}