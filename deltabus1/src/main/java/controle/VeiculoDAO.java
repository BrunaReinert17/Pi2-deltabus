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
	        con = Conexao.getInstacia();
	    }
	    
	    public ArrayList<Veiculo> listar() {
			Conexao c = Conexao.getInstacia();
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
					//v.setAno(rs.getLocalDate("ano"));
					v.setAcessorios(rs.getString("acessorios"));
					v.setLotacao(rs.getInt("lotacao"));
					v.setPlaca(rs.getString("placa"));
					v.setRenavam(rs.getString("renavam"));
					v.setCor(rs.getString("cor"));
					v.setTipoFrota(rs.getString("tipofrota"));
					v.setKmveiculo(rs.getInt("kmveiculo"));
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
		            String query = "INSERT INTO Clientes(Nome, numeroTelefone, email, cnpj, endereco_cep) VALUES (?, ?, ?, ?)";
		            PreparedStatement stm = c.prepareStatement(query);
		            stm.setLong(1, veiculo.getIdVeiculo());
		            stm.setString(2, veiculo.getMarca());
		            stm.setString(3, veiculo.getModelo());
		            stm.setDouble(4,veiculo.getPreco());
		            //stm.setLocalDate(5, veiculo.getAno());
		            stm.setString(6, veiculo.getAcessorios());
		            stm.setInt(7, veiculo.getLotacao());
		            stm.setString(8, veiculo.getPlaca());
		            stm.setString(9, veiculo.getRenavam());
		            stm.setString(10, veiculo.getCor());
		            stm.setString(11, veiculo.getTipoFrota());
		            stm.setLong(12, veiculo.getKmveiculo());
		            stm.setString(13, veiculo.getTipoCombustivel());
		            
		            valida = stm.executeUpdate();
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            con.fecharConexao();
		        }
		        return valida != 0;
		    }
	    
}
