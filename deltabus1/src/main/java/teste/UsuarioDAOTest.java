	package teste;
	
	import static org.junit.Assert.assertEquals;
	
	import java.util.ArrayList;
	import java.util.List;
	
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
	  Usuario u = new Usuario();
	 
	    u.setEmail("aluno@gmail.com");
	    u.setSenha("12345");
	    u.setCargo("Administrador");
	
	       UsuarioDAO dao = new UsuarioDAO();
	       boolean resultado = dao.listarUsuario(u);
	       assertEquals(true, resultado);
	   }
	@Test
	public void TestListarUsuarioErro() {
	Usuario u = null;
	UsuarioDAO dao = new UsuarioDAO();
	boolean resultado = dao.listarUsuario(u);
	assertEquals(false, resultado);
	
	}
	
	}