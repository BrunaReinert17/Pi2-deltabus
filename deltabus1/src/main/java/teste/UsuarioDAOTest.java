package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.UsuarioDAO;
import modelo.Usuario;

public class UsuarioDAOTest {
	// annotation
	@Test
	public void testMetodoInserirUsuarioSucesso() {
		Usuario u = new Usuario();

		u.setEmail("aluno@gmail.com");
		u.setSenha("12345");
		u.setCargo("Administrador");

		UsuarioDAO dao = new UsuarioDAO();
		boolean IdUsuarioInserido = dao.inserirUsuario(u);
		assertEquals(true, IdUsuarioInserido);
		// testes unitarios

	}

	@Test
	public void testMetodoInserirUsuarioErro() {
		Usuario u = null;
		UsuarioDAO dao = new UsuarioDAO();
		boolean IdUsuarioInserido = dao.inserirUsuario(u);
		assertEquals(false, IdUsuarioInserido);

	}

}
