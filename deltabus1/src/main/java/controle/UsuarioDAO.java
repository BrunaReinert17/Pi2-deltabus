package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Usuario;

public class UsuarioDAO implements InterfaceUsuario {

	private static UsuarioDAO instancia;
	private Conexao con;

	private UsuarioDAO() {

	}

	/**
	 * Ideal que o metodo retorne o id inserido no banco e nao apenas verdadeiro e
	 * falso
	 */
	public int inserirUsuario(Usuario usuario) {

		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		int id = 0;
		if (usuario != null) {

			try {
				String query = "INSERT INTO usuario(senha, email, cargo) VALUES (?, ?, ?)";
				PreparedStatement stm = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				stm.setString(1, usuario.getSenha());
				stm.setString(2, usuario.getEmail());
				stm.setString(3, usuario.getCargo());

				PreparedStatement ps = c.prepareStatement(query);

				int affectedRows = stm.executeUpdate();

				if (affectedRows == 0) {
					throw new SQLException("Creating user failed, no rows affected.");
				}

				try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						id = generatedKeys.getInt(1);
					} else {
						throw new SQLException("Creating user failed, no ID obtained.");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}
		}
		return id;
	}

	public Usuario selecionar(Usuario usuarioModelo) {
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuario where senha = ? AND email = ?");
			ps.setString(1, usuarioModelo.getSenha());
			ps.setString(2, usuarioModelo.getEmail());
			ps.setString(3, usuarioModelo.getCargo());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Long id = rs.getLong("idUsuario");
				String senha = rs.getString("senha");
				String email = rs.getString("email");
				String cargo = rs.getString("cargo");

				Usuario u = new Usuario(id, senha, email, cargo);
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return usuarioModelo;
	}

	@Override
	public Usuario alterarUsuario(Usuario usuario) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE usuario SET " + "Email = ?, " + "Senha = ?, " + "Cargo = ?   WHERE idUsuario = ?";
		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getCargo());
			ps.setLong(4, usuario.getIdUsuario());
			System.out.println(ps);

			ps.executeUpdate();
			return usuario;
//retorno nao esta de acordo com os testes
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return usuario;
	}

	public ArrayList<Usuario> listar() {

		Connection c = con.conectar();
		ArrayList<Usuario> usuarios = new ArrayList<>();

		try {
			String query = "SELECT * FROM usuario";
			PreparedStatement stm = c.prepareStatement(query);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();

				u.setIdUsuario(rs.getLong("idUsuario"));
				u.setSenha(rs.getString("idUsuario"));
				u.setEmail(rs.getString("email"));
				u.setCargo(rs.getString("cargo"));
				usuarios.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return usuarios;
	}

	public Usuario consultarLogin(Usuario usuario) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		Usuario usuarioConectado = null;

		try {

			PreparedStatement ps = c.prepareStatement("select * from usuario where email = ? and senha = ?");
			// metodo duplicado com selecionar usuario
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuarioConectado = new Usuario();
				long IdUsuario = rs.getLong("idUsuario");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				Blob blob = rs.getBlob("imagem");

				usuarioConectado.setIdUsuario(IdUsuario);
				usuarioConectado.setEmail(email);
				usuarioConectado.setSenha(senha);
				usuarioConectado.setCargo(cargo);
				usuarioConectado.setArquivoImagem(blob);
				System.out.println("retornando usuario conectado");
				return usuarioConectado;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return usuarioConectado;
	}

	public boolean excluirUsuario(Usuario usuario) {
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "DELETE FROM Usuario\r\n  WHERE idUsuario = ?";

		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.setLong(1, usuario.getIdUsuario());
			System.out.println(ps);
			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public static UsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;

	}

	@Override
	public boolean alterarImagemPerfil(File arquivoImagem, long idUsuario) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		String query = "UPDATE usuario SET imagem = ? WHERE idUsuario = ?";
		try {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(arquivoImagem);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			PreparedStatement ps = c.prepareStatement(query);
			ps.setBinaryStream(1, fis, (int) arquivoImagem.length());
			ps.setLong(2, idUsuario);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

	@Override
	public Usuario buscaUsuarioPorId(long idUsuario) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		Usuario usuarioConectado = null;

		try {

			PreparedStatement ps = c.prepareStatement("select * from usuario where idUsuario = ?");
			ps.setLong(1, idUsuario);

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuarioConectado = new Usuario();
				long IdUsuario = rs.getLong("idUsuario");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				Blob blob = rs.getBlob("imagem");

				usuarioConectado.setIdUsuario(IdUsuario);
				usuarioConectado.setEmail(email);
				usuarioConectado.setSenha(senha);
				usuarioConectado.setCargo(cargo);
				usuarioConectado.setArquivoImagem(blob);
				System.out.println("retornando usuario conectado");
				return usuarioConectado;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return usuarioConectado;
	}

}
