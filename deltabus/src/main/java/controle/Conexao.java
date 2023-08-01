package controle;

public class Conexao {
  import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao;
	private static Conexao instancia;
	private static final String DATABASE = "nome-banco";
	private static final String USER = "root";
	
	private static final String PSW = "aluno";

	private Conexao()  {
	}

	public static Conexao getInstacia() {
		if (instancia == null) {
			instancia = new Conexao();
		}
		return  instancia;
	}

	public static Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER,
					PSW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}

	public boolean fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}


