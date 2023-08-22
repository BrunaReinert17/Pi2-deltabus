package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Usuario;

public class UsuarioDAO implements InterfaceUsuario {

    private Conexao con;

    public UsuarioDAO() {
        con = Conexao.getInstacia();
    }

    @Override
    public boolean inserirUsuario(Usuario usuario) {
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
    public Usuario Cadastrar(Usuario usuarioModelo) {
        Connection c = con.conectar();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ? AND senha = ? AND email = ? AND cargo = ?");
            ps.setLong(1, usuarioModelo.getIdUsuario());
            ps.setString(2, usuarioModelo.getSenha());

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
}
