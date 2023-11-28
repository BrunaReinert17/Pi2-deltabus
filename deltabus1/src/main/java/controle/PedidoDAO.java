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
import modelo.FormaPagamento;
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
					 String tipo = rs.getString("tipoPagamento");
					 p.setTipoPagamento(FormaPagamento.getFormaPagamento(tipo));
					 
					 Long cnpj = rs.getLong("cnpj");
					 ClienteDAO clienteDao = new ClienteDAO();
					 Cliente c1 = new Cliente();
					 c1.setCnpj(cnpj);
					 c1 =  clienteDao.selecionarCliente(c1);
					 p.setCliente(c1);
					 System.out.println(cnpj);
					 System.out.println(c1);
					 
					 Long id = rs.getLong("idVeiculo");
					 Veiculo v = new Veiculo();
					 v.setIdVeiculo(id);
					 VeiculoDAO vei = new VeiculoDAO();
					 v = vei.selecionarVeiculo(v);
					 p.setVeiculo(v);
					 System.out.println(id);
					 System.out.println(v);
					 
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
		    if (pedido != null && pedido.getDataCompra() != null) {
		        con = Conexao.getInstancia();
		        Connection c = con.conectar();

		        int valida = 0;

		        String query = "INSERT INTO Pedido " + "(dataCompra, valorPago,tipoPagamento,Cnpj,  quantidade) " + "VALUES (?, ?, ?, ?, ?)";

		        try {
		            PreparedStatement ps = c.prepareStatement(query);
		            ps.setDate(1, java.sql.Date.valueOf(pedido.getDataCompra()));
		            ps.setDouble(2, pedido.getValorPago());
		            ps.setString(3, pedido.getTipoPagamento().getDescricao());
		            ps.setLong(4, pedido.getCliente().getCnpj());
		            ps.setInt(5, pedido.getQuantidade());

		            ps.executeUpdate();
		            return true;

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            con.fecharConexao();
		        }
		    }
		    return false;
		}

	
	

	public  boolean excluirPedido(Pedido pedido) {
		
		if (pedido != null) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM Pedido\r\n  WHERE Cnpj = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setLong(1, pedido.getCliente().getCnpj());
			ps.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		}
		return false;
	}

	@Override
	public boolean alterarPedido(Pedido pedido) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE Pedido   SET ValorPago = ?, dataCompra = ?, tipoPagamento = ?, quantidade = ?,  cnpj = ?   WHERE id_pedidos = ?";
		try {
			PreparedStatement p = c.prepareStatement(query);

			p.setDouble(1, pedido.getValorPago());
			p.setDate(2, java.sql.Date.valueOf(pedido.getDataCompra()));
			p.setString(3, pedido.getTipoPagamento().getDescricao());
			p.setInt(4,pedido.getQuantidade());
			p.setLong(5, pedido.getCliente().getCnpj());
			p.setInt(6, pedido.getId_pedido());
			
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
				String query = "INSERT INTO Pedido (dataCompra, valorPago, tipoPagamento, Cnpj, quantidade, idVeiculo) VALUES (?,?, ?,?,?,?)";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setDate(1, java.sql.Date.valueOf(pedido.getDataCompra()));
				stm.setDouble(2, pedido.getValorPago());
				stm.setString(3, pedido.getTipoPagamento().getDescricao());
				stm.setLong(4, pedido.getCliente().getCnpj());
				stm.setInt(5, pedido.getQuantidade());
				stm.setLong(6, pedido.getVeiculo().getIdVeiculo());

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

		String query = "DELETE FROM Pedido  WHERE Cnpj = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setLong(1, pedido.getCliente().getCnpj());
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