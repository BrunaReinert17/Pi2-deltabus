package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Endereco;

public class EnderecoDAO implements InterfaceEndereco {

	private Conexao con;

	@Override
	public Endereco listandoEndereco(Endereco endereco) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from endereco where cep = ?");
			ps.setLong(1, endereco.getCep());

			ResultSet rs = ps.executeQuery();
			Endereco enderecoConfirmado = new Endereco();

			while (rs.next()) {
				int cep = rs.getInt("cep");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				String uf = rs.getString("uf");

				enderecoConfirmado.setCep(cep);
				enderecoConfirmado.setCidade(cidade);
				enderecoConfirmado.setBairro(bairro);
				enderecoConfirmado.setRua(rua);
				enderecoConfirmado.setUf(uf);

				return enderecoConfirmado;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.fecharConexao();
		}
		return endereco;
		//return null;

	}

	@Override
	public long inserirEndereco(Endereco endereco) {
		System.out.println("end1");
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		int affectedRows = 0;
		System.out.println("end13");
		try {
			String query = "INSERT INTO endereco (cep, cidade, bairro, rua, UF) values(?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, endereco.getCep());
			stm.setString(2, endereco.getCidade());
			stm.setString(3, endereco.getBairro());
			stm.setString(4, endereco.getRua());
			stm.setString(5, endereco.getUf());
			System.out.println(stm);
			affectedRows = stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return affectedRows;

	}

	@Override
	public boolean excluirEndereco(Endereco endereco) {

		if (endereco != null) {
			con = Conexao.getInstancia();
			Connection c = con.conectar();

			String query = "DELETE FROM Endereco WHERE Cep = ?";

			try {
				PreparedStatement ps = c.prepareStatement(query);
				ps.setLong(1, endereco.getCep());
				ps.executeUpdate();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}
		}

		return false;
	}

	@Override
	public boolean alterarEndereco(Endereco endereco) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE Endereco SET cidade = ?, bairro = ?, rua = ?, uf = ? WHERE cep = ?";
		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, endereco.getCidade());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getRua());
			ps.setString(4, endereco.getUf());
			ps.setLong(5, endereco.getCep());

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

}
