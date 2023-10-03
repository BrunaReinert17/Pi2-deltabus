package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.UsuarioDAO;
import modelo.Usuario;

public class UsuarioDAOTest {
	//annotation
	@Test
	public void testMetodoInserirUsuario() {
		Usuario u = new Usuario();
		u.setNome("Maria");
		u.setIdade(19);
		
		UsuarioDAO dao = new UsuarioDAO();
		Integer IdUsuarioInserido = dao.inserir(null);
		assertEquals(false,IdUsuarioInserido);
		//testes unitarios
		
		
	}
}
