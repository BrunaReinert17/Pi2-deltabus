package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import controle.Conexao;
import controle.VeiculoDAO;
import modelo.Veiculo;



public class VeiculoDAOTest {
	
	@Test
	public void testMetodoinserirVeiculoSucesso() {
		Veiculo v = new Veiculo();
		
		
        v.setMarca("Marca");
        v.setModelo("Modelo");
        v.setPreco(20000.0);
        v.setAno(2008);
        v.setAcessorios("Ar Condicionado");
        v.setLotacao(10);
        v.setPlaca("ABC123");
        v.setRenavam("12345678901");
        v.setCor("Azul");
        v.setTipoFrota("Particular");
        v.setTipoCombustivel("Gasolina");
        v.setSituacao("Novo");;
		
		VeiculoDAO dao = new VeiculoDAO();
		boolean resultado = dao.inserirVeiculo(v);
		assertEquals(true,resultado);
		
		
		
		
		
		//testes unitarios
		//cenario que retorne como erro e sucesso
		
	}
	
	@Test
	
	public void testMetodoinserirVeiculoErro() {
		
			Veiculo v = null;
			VeiculoDAO dao = new VeiculoDAO();
			boolean resultado = dao.inserirVeiculo(v);
			assertEquals(false,resultado);
	}
	
	   @Test
	
	public void testMetodoExcluirVeiculoSucesso() {
		
	   Veiculo veiculo = new Veiculo();
	   veiculo.setRenavam("123456784"); 
		 
	    VeiculoDAO dao1 = new VeiculoDAO();
		boolean result = dao1.excluirVeiculo(veiculo);
		assertEquals(true,result);
		
		
		
		

		       
      }
	   
	   @Test
	   
	   public void testMetodoListarVeiculoSucesso(){
		   Veiculo veiculo = new Veiculo();
		   VeiculoDAO dao = new VeiculoDAO();
		   
		   ArrayList<Veiculo> veiculos = VeiculoDAO.listar();
	   
		     assertNotNull(veiculos);
	        assertFalse(veiculos.isEmpty());
	        
	        Veiculo primeiroVeiculo = veiculos.get(0);
	        assertEquals("Mercedes", primeiroVeiculo.getMarca());
	        assertEquals("Corolla", primeiroVeiculo.getModelo());
	        assertEquals(2022, primeiroVeiculo.getAno());
	        assertEquals(12345.67, primeiroVeiculo.getPreco(), 0.01); 
	        assertEquals("Ar-condicionado", primeiroVeiculo.getAcessorios());
	        assertEquals(5, primeiroVeiculo.getLotacao());
	        assertEquals("ABC123", primeiroVeiculo.getPlaca());
	        assertEquals("0987654321", primeiroVeiculo.getRenavam());
	        assertEquals("Prata", primeiroVeiculo.getCor());
	        assertEquals("Passeio", primeiroVeiculo.getTipoFrota());
	        assertEquals("Gasolina", primeiroVeiculo.getTipoCombustivel());
	        assertEquals("Disponível", primeiroVeiculo.getSituacao());
	        
	        
	   }
	  
	   
	   @ Test
	   public void testMetodoAlterarVeiculoSucesso(){
		   Veiculo v = new Veiculo();
		   
		    v.setMarca("Marca");
	        v.setModelo("Modelo");
	        v.setPreco(20000.0);
	        v.setAno(2008);
	        v.setAcessorios("Ar Condicionado");
	        v.setLotacao(10);
	        v.setPlaca("ABC123");
	        v.setRenavam("12345678901");
	        v.setCor("Vermelho");
	        v.setTipoFrota("Particular");
	        v.setTipoCombustivel("Gasolina");
	        v.setSituacao("SemiNovo");;
		   
	        VeiculoDAO DAO = new VeiculoDAO();
			boolean resultado = DAO.alterarVeiculo(v);
			assertTrue(resultado);
	       
	        
	        
	      
	     }
	  
		    }

	



