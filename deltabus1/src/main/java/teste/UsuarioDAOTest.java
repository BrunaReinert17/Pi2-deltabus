package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

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
		boolean resultado = dao.inserirUsuario(u);
		assertEquals(true, resultado);

	}

	@Test
	public void testMetodoInserirUsuarioErro() {
		Usuario u = null;
		UsuarioDAO dao = new UsuarioDAO();
		boolean resultado = dao.inserirUsuario(u);
		assertEquals(false, resultado);

	}

	@Test
	public void TestListarUsuario() {
		UsuarioDAO dao = new UsuarioDAO();
		ArrayList<Usuario> resultado = dao.listar();
		assertNotNull(resultado);
	}

	@Test
	public void TestExcluirUsuario() {
		Usuario u = new Usuario();
		u.setEmail("aluno@gmail.com");
		u.setSenha("12345");
		u.setCargo("Administrador");
		UsuarioDAO dao = new UsuarioDAO();
		boolean id = dao.inserirUsuario(u);

		boolean resultado = dao.excluirUsuario(u);
		assertEquals(true, resultado);
	}

	@Test
	public void TestExcluirUsuarioErro() {
		Usuario u = null;
		UsuarioDAO dao = new UsuarioDAO();
		boolean resultado = dao.excluirUsuario(u);
		assertEquals(false, resultado);
	}

	@Test
	public void TestAlterarUsuario() {
		Usuario u = new Usuario();

		u.setEmail("bruna@gmail.com");
		u.setSenha("1312");
		u.setCargo("Administrador");

		UsuarioDAO dao = new UsuarioDAO();
		Usuario resultado = dao.alterarUsuario(u);
		assertEquals(true, resultado);
	}

	@Test
	public void TestAlterarUsuarioErro() {
		Usuario u = null;
		UsuarioDAO dao = new UsuarioDAO();
		Usuario resultado = dao.alterarUsuario(u);
		assertEquals(false, resultado);
	}

}