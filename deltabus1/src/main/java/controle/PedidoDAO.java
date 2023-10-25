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
   
	 private static Conexao con;
	 
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

	public  boolean inserirPedido(Pedido pedido) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		int valida = 0;


		String query = "INSERT INTO Pedido " 
		+ "(id_pedidos, dataCompra, valorPago,tipoPagamento,renavam, Clientes, nomeCliente, quantidade) " 
		+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pedido.getId_pedidos());
			ps.setDate(2,java.sql.Date.valueOf (pedido.getDataCompra()));
			ps.setDouble(3, pedido.getValorPago());
			ps.setString(4, pedido.getTipoPagamento());
		    ps.setString(5,pedido.getRenavam());
		    ps.setString(6,pedido.getCliente());
		    ps.setString(7,pedido.getNomeCliente());
		    ps.setInt(8,pedido.getQuantidade());

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
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM Pedido\r\n  WHERE Cliente = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pedido.getCliente());
			ps.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean alterarPedido(Pedido pedido) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE Pedido\r\n   SET" + "ValorPago = ?\r\n" + "dataCompra = ?" + "tipoPagamento = ?"
				+ " quantidade = ?" + " nomeCliente = ?" + " Renavam = ?" + "cliente = ?  ,  WHERE id_pedidos = ?";
		try {
			PreparedStatement p = con.prepareStatement(query);

			
			p.setDouble(1, pedido.getValorPago());
			p.setDate(2,java.sql.Date.valueOf(pedido.getDataCompra()));
			p.setString(3, pedido.getTipoPagamento());
			p.setString(4, pedido.getCliente());
			p.setString(5, pedido.getRenavam());
			p.setString(6,pedido.getNomeCliente());
			p.setInt(7,pedido.getQuantidade());
			p.setInt(8, pedido.getId_pedidos());
			p.executeUpdate();

			c.fecharConexao();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}
	 
	 public static  boolean inserirPedido1(Pedido pedido) {
		    Connection c = con.conectar();
			int valida = 0;


			try {
				String query = "INSERT INTO Pedido (dataCompra, valorPago, tipoPagamento, renavam, Cliente, nomeCliente, quantidade) VALUES (?,?, ?, ?, ?,?,?)";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setDate(1, java.sql.Date.valueOf(pedido.getDataCompra()));
				stm.setDouble(2, pedido.getValorPago());
				stm.setString(3, pedido.getTipoPagamento());
				stm.setString(4, pedido.getRenavam());
				stm.setString(5, pedido.getCliente());
				stm.setString(6, pedido.getNomeCliente());
				stm.setInt(7, pedido.getQuantidade());

				valida = stm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}
			return valida != 0;
		}
}
