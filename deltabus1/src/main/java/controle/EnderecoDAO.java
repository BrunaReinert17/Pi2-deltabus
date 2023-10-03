package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Endereco;

public class EnderecoDAO implements InterfaceEndereco {
	
	private Conexao con;
	
	
	@Override
	public Endereco consultandoEndereco(Endereco endereco) {
		System.out.println(endereco.toString());
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement(
					"select * from endereco where cep = ?");
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
			return null;
		} finally {
			con.fecharConexao();
		}
		return null;

	}
	

	@Override
	public boolean inserirEndereco(Endereco endereco) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		int valida = 0;
		try {
			String query = "INSERT INTO endereco (cep, cidade, bairro, rua, UF)values(?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, endereco.getCep());
			stm.setString(2, endereco.getCidade());
			stm.setString(3, endereco.getBairro());
			stm.setString(4, endereco.getRua());
			stm.setString(5,endereco.getUf());

			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (valida == 0 ? false : true);
	}

	@Override
	public boolean excluirEndereco(Endereco endereco) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM Endereco\r\n  WHERE Cep = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setFloat(1, endereco.getCep());
			ps.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean alterarEndereco(Endereco endereco) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE Endereco\r\n   SET" + "cidade = ?\r\n" + "bairro = ?" + "rua = ?" + " estado = ?"
				+ "Uf = ? ,  WHERE cep = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, endereco.getCidade());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getRua());
			
			ps.setString(5, endereco.getUf());
			ps.setLong(6, endereco.getCep());

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

}
