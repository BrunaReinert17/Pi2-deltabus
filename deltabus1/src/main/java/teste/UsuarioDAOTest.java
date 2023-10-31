package teste;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import controle.UsuarioDAO;
import modelo.Usuario;
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioDAOTest {
	// annotation
	//if 
	@Test
	@Order(1)  
	public void testMetodoInserirUsuarioSucesso() {
		Usuario u = new Usuario();

		u.setEmail("aluno@gmail.com");
		u.setSenha("12345");
		u.setCargo("Administrador");

		UsuarioDAO dao = new UsuarioDAO();
		boolean resultado = dao.inserirUsuario(u);
		assertEquals(true, resultado);

	}

//	@Test
//	@Order(2)  
//	public void testMetodoInserirUsuarioErro() {
//		Usuario u = null;
//		UsuarioDAO dao = new UsuarioDAO();
//		boolean resultado = dao.inserirUsuario(u);
//		assertEquals(false, resultado);
//
//	}

	@Test
	@Order(2)  
	public void TestListarUsuario() {
		UsuarioDAO dao = new UsuarioDAO();
		ArrayList<Usuario> resultado = dao.listar();
		assertNotNull(resultado);
	}
//
//	@Test
//	@Order(4)  
//	public void TestExcluirUsuarioErro() {
//		Usuario u = null;
//		UsuarioDAO dao = new UsuarioDAO();
//		boolean resultado = dao.excluirUsuario(u);
//		assertEquals(false, resultado);
//	}
//
	@Test
	@Order(3)  
	public void TestAlterarUsuario() {
		
		Usuario u = new Usuario();
		u.setEmail("aluno@gmail.com");
		u.setSenha("12345");
		u.setCargo("Administrador");
		UsuarioDAO dao = new UsuarioDAO();
		
		u = dao.consultarLogin(u);
		u.setSenha("123456");
		Usuario resultado = dao.alterarUsuario(u);
		assertEquals(true, resultado);
	}
//
//	@Test
//	@Order(6)  
//	public void TestAlterarUsuarioErro() {
//		Usuario u = null;
//		UsuarioDAO dao = new UsuarioDAO();
//		Usuario resultado = dao.alterarUsuario(u);
//		assertEquals(false, resultado);
//	}
//

	@Test
	@Order(4)  
	public void TestExcluirUsuario() {

		Usuario u = new Usuario();
		u.setEmail("aluno@gmail.com");
		u.setSenha("123456");
		u.setCargo("Administrador");
		UsuarioDAO dao = new UsuarioDAO();
		
		u = dao.consultarLogin(u);
		System.out.println(u);
		boolean resultado = dao.excluirUsuario(u);
		assertEquals(true, resultado);
	}
}