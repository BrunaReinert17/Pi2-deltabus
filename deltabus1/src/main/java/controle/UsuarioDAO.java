package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Usuario;

public class UsuarioDAO implements InterfaceUsuario {

    private Conexao con;

    public UsuarioDAO() {
        con = Conexao.getInstancia();
    }

    @Override
    public boolean inserirUsuario(Usuario usuario) {
    	
    	Conexao con = Conexao.getInstancia();
        Connection c = con.conectar();
        
        int valida = 0;

        try {
            String query = "INSERT INTO usuario(idUsuario, senha, email, cargo) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = c.prepareStatement(query);
            stm.setLong(1, usuario.getIdUsuario());
            stm.setString(2, usuario.getSenha());
            stm.setString(3, usuario.getEmail());
            stm.setString(4, usuario.getCargo());

            valida = stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return valida != 0;
    }

    @Override
    public boolean deletarUsuario(Usuario usuario) {
        // Implemente a exclusão do usuário aqui
        return false;
    }

    @Override
    public Usuario selecionar (Usuario usuarioModelo) {
        Connection c = con.conectar();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM usuario where senha = ? AND email = ?");
            ps.setString(1, usuarioModelo.getSenha());
            ps.setString(2, usuarioModelo.getEmail());

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
        return null;
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) {
        // Implemente a atualização do usuário aqui
        return null;
    }

    public ArrayList<Usuario> listar() {
        Connection c = con.conectar();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            String query = "SELECT * FROM usuario";
            PreparedStatement stm = c.prepareStatement(query);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("idUsuario");
                String senha = rs.getString("senha");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");

                Usuario u = new Usuario(id, senha, email, cargo);
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

		try {

			con = Conexao.getInstancia();
			Connection c = con.conectar();
			PreparedStatement ps = c.prepareStatement("select * from usuario where email = ? and senha = ?");
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());

			ResultSet rs = ps.executeQuery();
			Usuario usuarioConectado = new Usuario();
			
			while (rs.next()) {
				long idUsuario = rs.getLong("idusuario");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");

				usuarioConectado.setIdUsuario(idUsuario);
				usuarioConectado.setEmail(email);
				usuarioConectado.setSenha(senha);
				usuarioConectado.setCargo(cargo);

				return usuarioConectado;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			con.fecharConexao();
		}

		return null;
	}

}
