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
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement(
					"select endereco.*, estados.cep as cep_estado, estados.cidade as cidade_estado, estados.bairro as bairro_estado from endereco inner join estados on estados.cep = endereco._estado where cep = ? ");
			ps.setLong(1, endereco.getCep());

			ResultSet rs = ps.executeQuery();
			Endereco enderecoConfirmado = new Endereco(0, null, null, null, null, null);

			while (rs.next()) {
				Long cep = rs.getLong("cep");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				String estado = rs.getString("estado");
				String uf = rs.getString("uf");

			
				enderecoConfirmado.setCep(cep);
				enderecoConfirmado.setCidade(cidade);
				enderecoConfirmado.setBairro(bairro);
				enderecoConfirmado.setRua(rua);
				enderecoConfirmado.setEstado(estado);
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
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		int valida = 0;
		try {
			String query = "INSERT INTO endereco (cep, cidade, bairro, rua, estado, UF)values(?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, endereco.getCep());
			stm.setString(2, endereco.getCidade());
			stm.setString(3, endereco.getBairro());
			stm.setString(4, endereco.getRua());
			stm.setString(5,endereco.getEstado());
			stm.setString(6,endereco.getUf());

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
		
		return false;
	}

	@Override
	public boolean alterarEndereco(Endereco endereco) {
		
		return false;
	}

}
