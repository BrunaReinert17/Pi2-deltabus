package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import controle.FuncionarioDAO;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;

public class FuncionarioDAOTest {

		//seguir como ordem
	
	@Test
	public void testMetodoinserirFuncionarioSucesso() {
		Funcionario f = new Funcionario();
        
		f.setDatanasci(LocalDate.of(1990, 1, 1));
		f.setGenero("Masculino");
		f.setEmail("bruna@gmail.com");
		f.setNumeroTelefone("1234567890");
		f.setCpf("1234567890l");

		Endereco endereco = new Endereco();

		endereco.setCep(12345 - 678);
		f.setEndereco(endereco);

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);
		f.setUsuario(usuario);

		FuncionarioDAO dao = new FuncionarioDAO();
		boolean resultado = dao.inserirFuncionario(f);
		assertEquals(true, resultado);
	}

	@Test
	public void testMetodoinserirFuncionarioErro() {
		Funcionario f = null;

		FuncionarioDAO dao = new FuncionarioDAO();

		boolean resultado = dao.inserirFuncionario(f);
		assertEquals(false, resultado);
	}
}
