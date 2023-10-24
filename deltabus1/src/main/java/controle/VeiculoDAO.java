package controle;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Veiculo;

public class VeiculoDAO {

	private Conexao con;

	public VeiculoDAO() {
		con = Conexao.getInstancia();
	}

	public ArrayList<Veiculo> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Veiculo> veiculos = new ArrayList<>();

		String query = "SELECT * FROM Veiculo";
		try {

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Veiculo v = new Veiculo();

				v.setIdVeiculo(rs.getLong("idveiculo"));
				v.setRenavam(rs.getString("renavam"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setCor(rs.getString("cor"));
				v.setPlaca(rs.getString("placa"));
				v.setLotacao(rs.getInt("lotacao"));
				v.setTipoFrota(rs.getString("tipofrota"));
				v.setTipoCombustivel(rs.getString("tipocombustivel"));
				v.setAcessorios(rs.getString("acessorios"));
				v.setAno(rs.getInt("ano"));
				v.setPreco(rs.getDouble("preco"));
				v.setSituacao(rs.getString("situacao"));
				veiculos.add(v);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		c.fecharConexao();
		return veiculos;
	}

	public boolean inserirVeiculo(Veiculo veiculo) {
		Connection c = con.conectar();
		int valida = 0;

		try {
			String query = "INSERT INTO Veiculo(IdVeiculo,marca, modelo, preco, ano, acessorios, lotacao, cor, tipoFrota, tipoCombustivel, placa, renavam, situacao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, veiculo.getIdVeiculo());
			stm.setString(2, veiculo.getMarca());
			stm.setString(3, veiculo.getModelo());
			stm.setDouble(4, veiculo.getPreco());
			stm.setInt(5, veiculo.getAno());
			stm.setString(6, veiculo.getAcessorios());
			stm.setInt(7, veiculo.getLotacao());
			stm.setString(8, veiculo.getPlaca());
			stm.setString(9, veiculo.getRenavam());
			stm.setString(10, veiculo.getCor());
			stm.setString(11, veiculo.getTipoFrota());
			stm.setString(12, veiculo.getTipoCombustivel());
			stm.setString(13, veiculo.getSituacao());

			valida = stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return valida != 0;
	}

	public static boolean excluirVeiculo(Veiculo veiculo) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM Veiculo\r\n  WHERE renavam = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, veiculo.getRenavam());
			ps.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean alterarVeiculo(Veiculo veiculo) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE Endereco\r\n   SET" + "Marca = ?\r\n" + "Modelo = ?" + "Preco = ?" + " Ano = ?"
				+ " Acessorios= ?" + "Lotacao = ?" + "Placa = ?" + "Renavam = ?" + "Cor = ?" + "TipoFrota = ?"
				+ "Tipocombustivel = ?" + "situacao = ?,  WHERE idveiculo = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, veiculo.getMarca());
			ps.setString(2, veiculo.getModelo());
			ps.setDouble(3, veiculo.getPreco());
			ps.setInt(4, veiculo.getAno());
			ps.setString(5, veiculo.getAcessorios());
			ps.setInt(6, veiculo.getLotacao());
			ps.setString(7, veiculo.getPlaca());
			ps.setString(8, veiculo.getRenavam());
			ps.setString(9, veiculo.getCor());
			ps.setString(10, veiculo.getTipoFrota());
			ps.setString(12, veiculo.getTipoCombustivel());
			ps.setString(13, veiculo.getSituacao());
			ps.setLong(14, veiculo.getIdVeiculo());

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
