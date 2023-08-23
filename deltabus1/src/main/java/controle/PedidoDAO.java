package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Veiculo;

public class PedidoDAO implements InterfacePedido{
   
	 private Conexao con;
	 
	 public PedidoDAO() {
	        con = Conexao.getInstacia();
	    }
	 
	 public ArrayList<Pedido> listar() {
			Conexao c = Conexao.getInstacia();
			Connection con = c.conectar();

			ArrayList<Pedido> pedidos = new ArrayList<>();

			String query = "SELECT * FROM pedido";
			try {
				
				PreparedStatement ps = con.prepareStatement(query);

				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					 String veiculo = rs.getString("veiculo");

					String cliente = rs.getString("cliente");
					Date dataCompra = rs.getDate("dataCompra");
					Double valorPago = rs.getDouble("valorPago");
					String tipoPagamento = rs.getString("tipoPagamento");

					
					//Pedido p = new Pedido(veiculo, tipoPagamento, null, valorPago, tipoPagamento);
					//p.setVeiculo(null);;
					//p.setCliente(null);
				//	p.setDataCompra(null);
					//p.setValorPago(valorPago);
					//p.setTipoPagamento(tipoPagamento);
					//pedidos.add(p);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			c.fecharConexao();

			return pedidos;
		}

	@Override
	public boolean inserirPedido(Pedido pedido) {
		Conexao c = Conexao.getInstacia();

		Connection con = c.conectar();

		String query = "INSERT INTO Pedido " 
		+ "(id_pedidos, dataCompra, valorPago,tipoPagamento,veiculo_idVeiculo,Cliente_cnpj) " 
		+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pedido.getVeiculo());
			//ps.setLong(2, pedido.getDataCompra());
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
