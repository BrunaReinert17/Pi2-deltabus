package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Pedido;
import modelo.Veiculo;

public class PedidoDAO implements InterfacePedido{
   
	 private Conexao con;
	 
	 public PedidoDAO() {
	        con = Conexao.getInstancia();
	    }
	 
	 public ArrayList<Pedido> listar() {
			Conexao c = Conexao.getInstancia();
			Connection con = c.conectar();

			ArrayList<Pedido> pedidos = new ArrayList<>();

			String query = "SELECT * FROM pedido";
			try {
				
				PreparedStatement ps = con.prepareStatement(query);

				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					 String id_pedido = rs.getString("id_pedido");

					 Pedido pedido = new Pedido();
						
					 pedido.setVeiculo(rs.getInt("veiculo"));
					 pedido.setCliente(rs.getString("cliente"));
					 //pedido.setDataCompra(rs.getString("datacompra"));
					 pedido.setValorPago(rs.getDouble("valorpago"));
					 pedido.setTipoPagamento(rs.getString("cnpj"));


				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			c.fecharConexao();

			return pedidos;
		}

	@Override
	public boolean inserirPedido(Pedido pedido) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO Pedido " 
		+ "(id_pedidos, dataCompra, valorPago,tipoPagamento,veiculo_idVeiculo,Cliente_cnpj) " 
		+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pedido.getVeiculo());
			ps.setLong(2, pedido.getDataCompra());
			ps.setDouble(3, pedido.getValorPago());
			ps.setString(4, pedido.getTipoPagamento());
			ps.setInt(5, pedido.getVeiculo());
			ps.setString(6, pedido.getCliente());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean excluirPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}
	 
	 
	
}
