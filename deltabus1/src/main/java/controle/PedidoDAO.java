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

			ArrayList<Pedido> listPedido = new ArrayList<>();

			String query = "SELECT * FROM pedido";
			
			try {
				
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					
					 Pedido p = new Pedido();

					 p.setId_pedidos(rs.getInt("id_pedidos"));
					 p.setDataCompra(rs.getDate("dataCompra").toLocalDate());
					 p.setQuantidade(rs.getInt("quantidade"));
					 p.setValorPago(rs.getDouble("valorPago"));
					 p.setTipoPagamento(rs.getString("tipoPagamento"));
					 p.setCliente(rs.getString("cliente"));
					 p.setRenavam(rs.getString("renavam"));
					 p.setNomeCliente(rs.getString("nomeCliente"));
					 listPedido.add(p);
					 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				c.fecharConexao();
			}

			

		return listPedido;
		
	}

	public boolean inserirPedido(Pedido pedido) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		int valida = 0;


		String query = "INSERT INTO Pedido " 
		+ "(id_pedido, dataCompra, valorPago,tipoPagamento,renavam, Clientes, nomeCliente, quantidade) " 
		+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, pedido.getId_pedido());
			ps.setDate(2,java.sql.Date.valueOf (pedido.getDataCompra()));
			ps.setDouble(3, pedido.getValorPago());
			ps.setString(4, pedido.getTipoPagamento());
			ps.setString(5, pedido.getRenavam());
			ps.setString(6, pedido.getCliente());
			ps.setString(7, pedido.getNomeCliente());
			ps.setInt(8, pedido.getQuantidade());

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return false;
	}

	public  boolean excluirPedido(Pedido pedido) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM Pedido\r\n  WHERE Cliente = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, pedido.getCliente());
			ps.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

	@Override
	public boolean alterarPedido(Pedido pedido) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE Pedido\r\n   SET" + "ValorPago = ?\r\n" + "dataCompra = ?" + "tipoPagamento = ?"
				+ " quantidade = ?" + " nomeCliente = ?" + " Renavam = ?" + "cliente = ?  ,  WHERE id_pedido = ?";
		try {
			PreparedStatement p = c.prepareStatement(query);

			p.setDouble(1, pedido.getValorPago());
			p.setDate(2, java.sql.Date.valueOf(pedido.getDataCompra()));
			p.setString(3, pedido.getTipoPagamento());
			p.setString(4, pedido.getCliente());
			p.setString(5, pedido.getRenavam());
			p.setString(6,pedido.getNomeCliente());
			p.setInt(7,pedido.getQuantidade());
			p.setInt(8, pedido.getId_pedido());
			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
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
	public static boolean excluirPedido1(Pedido pedido) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM Pedido\r\n  WHERE Cliente = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, pedido.getCliente());
			int n =ps.executeUpdate();
			return (n==1);  /// retorna true se excluir algo
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}
}