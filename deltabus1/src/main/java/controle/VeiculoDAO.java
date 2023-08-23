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
					Endereco endereco = new Endereco();
					
				//	v.setNome(rs.getString("nome"));
				//	v.setNumeroTelefone(rs.getInt("numeroTelefone"));
				//	v.setEmail(rs.getString("email"));
				//	v.setCpf(rs.getDouble("cpf"));
				//	v.setCnpj(rs.getLong("cnpj"));
					endereco.setCep(rs.getInt("endereco_cep"));
				//	v.setEndereco(endereco);
					

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			c.fecharConexao();

			return veiculos;
		}
	    
}
