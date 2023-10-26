package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.ClienteDAO;
import modelo.Cliente;

public class ClienteDAOTest {
	@Test
	public void testMetodoInserirCliente() {
		Cliente c = new Cliente();
		c.setNome("Gisele");
		c.setNumeroTelefone("(12)34567-8921");
		c.setEmail("gisele@gmail.com");
		c.setCpf(null);
		c.setCnpj(null);

		ClienteDAO dao = new ClienteDAO();
		boolean IdClienteInserido = dao.inserirCliente(c);
		assertEquals(true, IdClienteInserido);
	}

}
