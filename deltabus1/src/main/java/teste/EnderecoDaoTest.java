package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.EnderecoDAO;
import controle.VeiculoDAO;
import modelo.Endereco;
import modelo.Veiculo;

public class EnderecoDaoTest {

	
	@Test
	public void testMetodoInserirEndereco() {
		Endereco e = new Endereco();
		e.setCep(89116881);
		e.setCidade("Gaspar");
		e.setBairro("Lagoa");
		e.setRua(" Jóse Reinert");
		e.setUf("SC");
		
		EnderecoDAO ende = new EnderecoDAO();
		boolean IdEnderecoInserido = ende.inserirEndereco(e);
		assertEquals(true,IdEnderecoInserido );
	}
	
	 @Test
		
		public void testMetodoExcluirEnderecoSucesso() {
			
		   Endereco endereco = new Endereco();
		   endereco.setCep(21346560); 
			 
		    EnderecoDAO dao1 = new EnderecoDAO();
			boolean result = dao1.excluirEndereco(endereco);
			assertEquals(true,result);
			
			
			
			

			       
	      }
}
