package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import modelo.Funcionario;

public class FuncionarioDAO implements InterfaceFuncionario {

	private Conexao con;
	private static ArrayList<Funcionario> listaFuncionario;

	private static FuncionarioDAO funcionarioDao;

	public static void getIntancia() {
		if (funcionarioDao == null) {
			funcionarioDao = new FuncionarioDAO();
			listaFuncionario = new ArrayList<Funcionario>();

			listaFuncionario.add(new Funcionario("Bruna", 14058567937l, "bruna@gmail.com", "secretaria", "bruna18"));
			listaFuncionario
					.add(new Funcionario("agatha", 123456789101l, "agatha@gmail.com", "vice secretaria", "agatha12"));
			listaFuncionario
					.add(new Funcionario("Maria Tereza", 123456789101l, "maria@gmail.com", "gerente", "maria05"));
			listaFuncionario
					.add(new Funcionario("Aguida", 123456789101l, "aguida@gmail.com", "vice gerente", "aguida123"));
		}

	}

	@Override
	public boolean inserirFuncionario(Funcionario funcionario) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		int valida = 0;
		try {
			String query = "INSERT INTO Funcionario (cpf, nome, dataNascimento, genero, numerotelefone,email, Usuario_idUsuario,endereco_cep)values(?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setDouble(1, funcionario.getCpf());
			;
			stm.setString(2, funcionario.getNome());
			// stm.setDate(5, Date.valueOf(funcionario.getDatanasci()));
			stm.setString(4, funcionario.getGenero());
			stm.setLong(5, funcionario.getNumeroTelefone());
			stm.setString(6, funcionario.getEmail());
			// stm.setLong(6, funcionario.getUsuario().getId());
			// stm.setInt(7, funcionario.getEndereco().getCep());

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Funcionario alterarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return null;
	}
}