package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.EnderecoDAO;
import modelo.Endereco;

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
}
