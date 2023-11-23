package controle;

import java.io.File;

import modelo.Usuario;

public interface InterfaceUsuario {

	public int inserirUsuario(Usuario usuario);

	public boolean excluirUsuario(Usuario usuario);

	public Usuario alterarUsuario(Usuario usuario);

	public Usuario selecionar(Usuario usuarioModelo);
	
	public boolean alterarImagemPerfil(File arquivoImagem, long idUsuario);
	

}