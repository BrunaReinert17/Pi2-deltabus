package controle;

import modelo.Usuario;

public interface InterfaceUsuario {

	public int inserirUsuario(Usuario usuario);

	public boolean excluirUsuario(Usuario usuario);

	public Usuario alterarUsuario(Usuario usuario);

	public Usuario selecionar(Usuario usuarioModelo);

}