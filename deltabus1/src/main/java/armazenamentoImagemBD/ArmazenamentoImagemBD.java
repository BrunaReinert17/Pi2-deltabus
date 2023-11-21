package armazenamentoImagemBD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ArmazenamentoImagemBD {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/deltabus2";
        String usuario = "root";
        String senha = "aluno";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, senha)) {
            // Caminho para a imagem no sistema de arquivos
        	String caminhoImagem = "C:/Users/Aluno/Desktop/github/Pi2-deltabus/deltabus1/src/main/java/imagem/PerfilZoroSola.jpg";

            // Prepara o arquivo da imagem para leitura
            File imagemFile = new File(caminhoImagem);
            FileInputStream fis = new FileInputStream(imagemFile);

            // Prepara a declaração SQL para inserir a imagem no banco de dados
            String sql = "INSERT INTO imagens (nome, conteudo) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, imagemFile.getName());
                statement.setBinaryStream(2, fis, (int) imagemFile.length());

                // Executa a atualização
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " linha(s) afetada(s).");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
