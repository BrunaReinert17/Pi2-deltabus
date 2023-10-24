package controle;

import modelo.Usuario;

public interface InterfaceUsuario {

	public boolean inserirUsuario(Usuario usuario);

	public boolean excluirUsuario(Usuario usuario);

	public Usuario alterarUsuario(Usuario usuario);

	public Usuario selecionar(Usuario usuarioModelo);

}