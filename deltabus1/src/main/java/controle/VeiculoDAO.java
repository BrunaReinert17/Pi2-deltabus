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
					 long veiculo = rs.getLong("veiculo");

					 Veiculo v = new Veiculo();
					
					v.setIdVeiculo(rs.getLong("idveiculo"));
					v.setMarca(rs.getString("marca"));
					v.setModelo(rs.getString("modelo"));
					v.setPreco(rs.getDouble("preco"));
					v.setAno(rs.getDate("ano"));
					v.setAcessorios(rs.getString("acessorios"));
					v.setLotacao(rs.getInt("lotacao"));
					v.setPlaca(rs.getString("placa"));
					v.setRenavam(rs.getString("renavam"));
					v.setCor(rs.getString("cor"));
					v.setTipoFrota(rs.getString("tipofrota"));
					v.setTipoCombustivel(rs.getString("tipocombustivel"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			c.fecharConexao();

			return veiculos;
		}
	    
	    
	   
		public boolean inserirVeiculo (Veiculo veiculo) {
			 Connection c = con.conectar();
		        int valida = 0;

		        try {
		            String query = "INSERT INTO Veiculos(marca, modelo, preco, ano, acessorios, lotacao, cor, tipoFrota, tipoCombustivel, consultarEstoque_Codigoveiculo, placa, renavam, situacao) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";
		            PreparedStatement stm = c.prepareStatement(query);
		            stm.setLong(1, veiculo.getIdVeiculo());
		            stm.setString(2, veiculo.getMarca());
		            stm.setString(3, veiculo.getModelo());
		            stm.setDouble(4,veiculo.getPreco());
		            stm.setDate(5, veiculo.getAno());
		            stm.setString(6, veiculo.getAcessorios());
		            stm.setInt(7, veiculo.getLotacao());
		            stm.setString(8, veiculo.getPlaca());
		            stm.setString(9, veiculo.getRenavam());
		            stm.setString(10, veiculo.getCor());
		            stm.setString(11, veiculo.getTipoFrota());
		            stm.setString(13, veiculo.getTipoCombustivel());
		            
		            valida = stm.executeUpdate();
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            con.fecharConexao();
		        }
		        return valida != 0;
		    }
		
		public boolean excluirVeiculo(Veiculo veiculo) {

			Conexao c = Conexao.getInstancia();
			Connection con = c.conectar();

			String query = "DELETE FROM Veiculo\r\n  WHERE idVeiculo = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setDouble(1, veiculo.getIdVeiculo());
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
				
				
				String query = "UPDATE Endereco\r\n   SET" 
						+ "Marca = ?\r\n" + "Modelo = ?" + "Preco = ?" + " Ano = ?" + " Acessorios= ?" + "Lotacao = ?" + "Placa = ?" + "Renavam = ?" + "Cor = ?" + "TipoFrota = ?"  + "Tipocombustivel = ?" + "situacao = ?,  WHERE idveiculo = ?";
				try {
					PreparedStatement ps = con.prepareStatement(query);

					ps.setString(1, veiculo.getMarca());
					ps.setString(2, veiculo.getModelo());
					ps.setDouble(3, veiculo.getPreco());
				//	ps.setDate(4,java.sql.Date.valueOf( veiculo.getAno()));
					ps.setString(5, veiculo.getAcessorios());
					ps.setInt(6, veiculo.getLotacao());
					ps.setString(7, veiculo.getPlaca());
					ps.setString(8, veiculo.getRenavam());
					ps.setString(9, veiculo.getCor());
					ps.setString(10, veiculo.getTipoFrota());
					ps.setString(12, veiculo.getTipoCombustivel());
					ps.setBoolean(13, veiculo.isSituacao());
					ps.setLong(14, veiculo.getIdVeiculo());
					
					
					ps.executeUpdate();
					
					c.fecharConexao();
					return true;
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					c.fecharConexao();
				}
				
				return false;
		}
	    
}
