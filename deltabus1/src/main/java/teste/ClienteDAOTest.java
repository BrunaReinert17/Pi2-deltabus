package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.ClienteDAO;
import modelo.Cliente;

public class ClienteDAOTest {
	@Test
	public void testMetodoInserirCliente() {
		Cliente c = new Cliente();
		c.setNome("Livia");
		c.setNumeroTelefone(479871767);
		c.setEmail("agatha@gmail.com");
		//c.setCpf(04774867940);
		
		
		ClienteDAO dao = new ClienteDAO();
		boolean IdClienteInserido = dao.inserirCliente(c);
		assertEquals(true,IdClienteInserido);
		//testes unitarios
		
		
	}

}
