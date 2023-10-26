package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import controle.PedidoDAO;
import controle.VeiculoDAO;
import modelo.Pedido;
import modelo.Veiculo;

public class PedidoDAOTest {

	 @Test 
	 
	 public void testMetodoinserirPedido() {
			Pedido p = new Pedido();
			
			
	        p.setMarca("Marca");
	        p.setModelo("Modelo");
	        p.setPreco(20000.0);
	        p.setAno(2008);
	        p.setAcessorios("Ar Condicionado");
	        p.setLotacao(10);
	        p.setPlaca("ABC123");
	        p.setRenavam("12345678901");
	        p.setCor("Azul");
	        p.setTipoFrota("Particular");
	        p.setTipoCombustivel("Gasolina");
	        p.setSituacao("Novo");;
			
			PedidoDAO dao = new PedidoDAO();
			boolean resultado = dao.inserirPedido(p);
			assertEquals(true,resultado);
			
			
			
			
			
			//testes unitarios
			
			
		}
	 
}
