package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Veiculo;

public class VeiculoDAO {

	private static Conexao con;

	public VeiculoDAO() {
		con = Conexao.getInstancia();
	}

	public static ArrayList<Veiculo> listar() {
		Connection c = con.conectar();
		ArrayList<Veiculo> veiculos = new ArrayList<>();

		String query = "SELECT * FROM Veiculo";
		try {

			PreparedStatement ps = c.prepareStatement(query);

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

		} catch (Exception e) {
			e.printStackTrace();
		}finally {

		con.fecharConexao();
		}
		return veiculos;
	}

	public boolean inserirVeiculo(Veiculo veiculo) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		boolean valida = false;
		
		if(veiculo != null) {

		try {
			String query = "INSERT INTO Veiculo(marca, modelo, preco, ano, acessorios, lotacao, cor, tipoFrota, tipoCombustivel, placa, renavam, situacao) VALUES (?,?, ?, ?, ?,?,?,?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, veiculo.getMarca());
			stm.setString(2, veiculo.getModelo());
			stm.setDouble(3, veiculo.getPreco());
			stm.setInt(4, veiculo.getAno());
			stm.setString(5, veiculo.getAcessorios());
			stm.setInt(6, veiculo.getLotacao());
			stm.setString(7, veiculo.getPlaca());
			stm.setString(8, veiculo.getRenavam());
			stm.setString(9, veiculo.getCor());
			stm.setString(10, veiculo.getTipoFrota());
			stm.setString(11, veiculo.getTipoCombustivel());
			stm.setString(12, veiculo.getSituacao());

			valida = stm.executeUpdate() == 0 ? false : true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	}
		return valida;
	}
	

	public boolean excluirVeiculo(Veiculo veiculo) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM Veiculo WHERE renavam = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, veiculo.getRenavam());
			ps.executeUpdate();

			
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			c.fecharConexao();
		}

		return false;
	}

	public static boolean alterarVeiculo(Veiculo veiculo) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE Veiculo " + "SET Marca = ?, " + "Modelo = ?, " + "Preco = ?, " + "Ano = ?, " + "Acessorios = ?, " +  "Lotacao = ?, " + "Placa = ?, " +  "Renavam = ?, " +  "Cor = ?, " +  "TipoFrota = ?, " 
		+ "TipoCombustivel = ?, " + "Situacao = ? " + "WHERE renavam = ?";
		try {
			PreparedStatement ps = c.prepareStatement(query);

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
			ps.setString(11, veiculo.getTipoCombustivel());
			ps.setString(12, veiculo.getSituacao());
			ps.setString(13, veiculo.getRenavam());
		

			int sucesso = ps.executeUpdate();
			
			if(sucesso > 0) {
				return true;
			}
			else { 
				return false;
			}
			
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}
	
	

	public Veiculo selecionarVeiculo (Veiculo veiculoModelo) {
        Connection c = con.conectar();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM veiculo where idVeiculo = ?");
            ps.setLong(1, veiculoModelo.getIdVeiculo());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	
            	Veiculo v = new Veiculo();
            	v.setIdVeiculo(rs.getLong("idVeiculo"));
            	v.setMarca(rs.getString("marca"));
            	v.setModelo(rs.getString("modelo"));
            	v.setPreco(rs.getDouble("preco"));
            	v.setAno(rs.getInt("ano"));
            	v.setAcessorios(rs.getString("acessorios"));
            	v.setLotacao(rs.getInt("lotacao"));
            	v.setCor(rs.getString("cor"));
            	v.setTipoFrota(rs.getString("tipoFrota"));
            	v.setTipoCombustivel(rs.getString("tipoCombustivel"));
            	v.setPlaca(rs.getString("placa"));
            	v.setRenavam(rs.getString("renavam"));
            	v.setSituacao(rs.getString("situacao"));
            	
              return v;

               
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return null;
    }

}
