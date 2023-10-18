package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.VeiculoDAO;
import modelo.Veiculo;



public class VeiculoDAOTest {
	
	@Test
	public void testMetodoinserirVeiculo() {
		Veiculo v = new Veiculo();
		
		v.setIdVeiculo((long) 6);
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
		
		
	}
}


