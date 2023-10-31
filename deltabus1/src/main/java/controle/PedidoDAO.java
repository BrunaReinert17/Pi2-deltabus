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

					 p.setId_pedido(rs.getInt("id_pedidos"));
					 p.setDataCompra(rs.getDate("dataCompra").toLocalDate());
					 p.setQuantidade(rs.getInt("quantidade"));
					 p.setValorPago(rs.getDouble("valorPago"));
					 p.setTipoPagamento(rs.getString("tipoPagamento"));
					 p.setCnpj(rs.getString("cnpj"));
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
		+ "(id_pedido, dataCompra, valorPago,tipoPagamento,renavam, Cnpj, nomeCliente, quantidade) " 
		+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, pedido.getId_pedido());
			ps.setDate(2,java.sql.Date.valueOf (pedido.getDataCompra()));
			ps.setDouble(3, pedido.getValorPago());
			ps.setString(4, pedido.getTipoPagamento());
			ps.setString(5, pedido.getRenavam());
			ps.setString(6, pedido.getCnpj());
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

	@Override
	public boolean excluirPedido(Pedido pedido) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM Pedido\r\n  WHERE Cliente = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, pedido.getCnpj());
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

		String query = "UPDATE Pedido   SET ValorPago = ?, dataCompra = ?, tipoPagamento = ?, quantidade = ?, nomeCliente = ?, Renavam = ?, cnpj = ?   WHERE id_pedidos = ?";
		try {
			PreparedStatement p = c.prepareStatement(query);

			p.setDouble(1, pedido.getValorPago());
			p.setDate(2, java.sql.Date.valueOf(pedido.getDataCompra()));
			p.setString(3, pedido.getTipoPagamento());
			p.setInt(4,pedido.getQuantidade());
			p.setString(5,pedido.getNomeCliente());
			p.setString(6, pedido.getRenavam());
			p.setString(7, pedido.getCnpj());
			p.setInt(8, pedido.getId_pedido());
			
			System.out.print(p);
			p.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return true;
	}
	 
	 public static  boolean inserirPedido1(Pedido pedido) {
		    Connection c = con.conectar();
			int valida = 0;


			try {
				String query = "INSERT INTO Pedido (dataCompra, valorPago, tipoPagamento, renavam, Cnpj, nomeCliente, quantidade) VALUES (?,?, ?, ?, ?,?,?)";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setDate(1, java.sql.Date.valueOf(pedido.getDataCompra()));
				stm.setDouble(2, pedido.getValorPago());
				stm.setString(3, pedido.getTipoPagamento());
				stm.setString(4, pedido.getRenavam());
				stm.setString(5, pedido.getCnpj());
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
