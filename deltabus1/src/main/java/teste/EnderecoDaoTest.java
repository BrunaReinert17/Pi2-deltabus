package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import controle.EnderecoDAO;
import controle.VeiculoDAO;
import modelo.Endereco;
import modelo.Veiculo;

public class EnderecoDaoTest {

	@Test
	public void testMetodoInserirEndereco() {
		Endereco e = new Endereco();
		e.setCep(891166538);
		e.setCidade("Gaspar");
		e.setBairro("Lagoa");
		e.setRua(" Jóse Reinert");
		e.setUf("SC");

		EnderecoDAO ende = new EnderecoDAO();
		// boolean resultado = ende.inserirEndereco(e);
		// (true,resultado );
	}

	@Test
	public void testMedotoInserirEnderecoErro() {
		Endereco e = null;
		EnderecoDAO dao = new EnderecoDAO();
		// boolean resultado = dao.inserirEndereco(e);
		// assertEquals(false,resultado );
	}

	@Test
	public void TestExcluirEndereco() {
		Endereco e = new Endereco();
		e.setCep(89116831);
		e.setCidade("Gaspar");
		e.setBairro("Lagoa");
		e.setRua("figueira");
		e.setUf("SC");

		EnderecoDAO dao = new EnderecoDAO();

		boolean resultado = dao.excluirEndereco(e);
		assertNotNull(resultado);
	}

	@Test
	public void TestExcluirEnderecoErro() {
		Endereco e = null;
		EnderecoDAO dao = new EnderecoDAO();
		boolean resultado = dao.excluirEndereco(e);
		assertEquals(false, resultado);
	}

	@Test
	public void TestAlterarEndereco() {
		Endereco e = new Endereco();

		e.setCep(888888894);
		e.setCidade("Blumenau");
		e.setBairro("Progresso");
		e.setRua("Zimerman");
		e.setUf("RS");

		EnderecoDAO dao = new EnderecoDAO();
		boolean resultado = dao.alterarEndereco(e);
		assertNotNull(resultado);
	}

}
