package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Usuario;

public class UsuarioDAO implements InterfaceUsuario {

	private Conexao con;
	private Usuario usuarioModelo;
	private Usuario usuario;
	
	@Override
	public boolean inserirUsuario(Usuario usuario) {
		this.usuario = usuario;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;

		try {
			String query = "INSERT INTO usuario(idUsuario, senha, email, cargo) values(?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, usuario.getIdUsuario());
			stm.setString(2, usuario.getSenha());
			stm.setString(3, usuario.getEmail());
			stm.setString(4,usuario.getCargo());

			valida = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);

	}
	
	@Override
	public boolean deletarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Usuario Cadastrar(Usuario usuarioModelo) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from usuario where login = ? and senha = ? ");
			ps.setLong(1, usuarioModelo.getIdUsuario());
			ps.setString(2, usuarioModelo.getSenha());

			ResultSet rs = ps.executeQuery();
			InterfaceEndereco endereConfirmado = new EnderecoDAO();

			while (rs.next()) {
				Long id = rs.getLong("idusuario");
				String senha = rs.getString("senha");
				String email = rs.getString("email");
				String cargo = rs.getString("cargo");

				Usuario u = new Usuario(id, senha, email, cargo);
				u.setIdUsuario(id);
				u.setSenha(senha);
				u.setEmail(email);
				u.setCargo(cargo);

				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			con.fecharConexao();
		}
		return null;

	}


	@Override
	public Usuario alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
