package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import controle.ClienteDAO;
import controle.VeiculoDAO;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Veiculo;

public class ClienteDAOTest {
	@Test
	public void testMetodoInserirCliente() {
		Cliente c = new Cliente();
		
		c.setNome("Gisele");
		c.setNumeroTelefone("(12)34567-8921");
		c.setEmail("gisele@gmail.com");
		c.setCpf("4545545441");
		c.setCnpj(Long.valueOf(464468437));

		Endereco endereco = new Endereco();

		endereco.setCep(21346560);
		c.setEndereco(endereco);

		ClienteDAO dao = new ClienteDAO();
		boolean resultado = dao.inserirCliente(c);
		assertEquals(true, resultado);
	}

	@Test
	public void testMetodoinserirClienteErro() {

		Cliente c = null;
		ClienteDAO dao = new ClienteDAO();
		boolean resultado = dao.inserirCliente(c);
		assertEquals(false, resultado);
	}

	@Test

	public void testMetodoExcluirClienteSucesso() {

		Cliente cliente = new Cliente();
		cliente.setCnpj(Long.valueOf(464468437));

		ClienteDAO dao1 = new ClienteDAO();
		boolean result = dao1.excluirCliente(cliente);
		assertEquals(true, result);

	}

	@Test

	public void testMetodoListarClienteSucesso() {
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();

		ArrayList<Cliente> c = ClienteDAO.listar();

		assertNotNull(c);
		assertFalse(c.isEmpty());

		Cliente primeiroCliente = c.get(0);
		assertEquals("Gisele", primeiroCliente.getNome());
		assertEquals("(12)34567-8921", primeiroCliente.getNumeroTelefone());
		assertEquals("gisele@gmail.com", primeiroCliente.getEmail());
		assertEquals("4545545441", primeiroCliente.getCpf());
		// assertEquals(464468437, primeiroCliente.getCnpj());
		assertEquals(21346560, primeiroCliente.getEndereco().getCep());

	}

	@Test
	public void testMetodoAlterarClienteSucesso() {
		Cliente c = new Cliente();

		c.setNome("Gisele");
		c.setNumeroTelefone("Modelo");
		c.setEmail("gisele@gmail.com");
		c.setCpf("4545545441");
		c.setCnpj(Long.valueOf(464468437));

		Endereco endereco = new Endereco();

		endereco.setCep(21346560);
		c.setEndereco(endereco);;

		ClienteDAO DAO = new ClienteDAO();
		boolean resultado = DAO.alterarCliente(c);
		assertTrue(resultado);

	}

}
