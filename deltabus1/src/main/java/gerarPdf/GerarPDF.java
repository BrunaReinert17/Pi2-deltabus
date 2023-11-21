package gerarPdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GerarPDF {

    public static void main(String[] args) {
        String nomeBancoDados = "deltabus2.db";
        String arquivoPDF = "relatorio.pdf";

     /*   try {
            // Conectar ao banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:sqlite:" + nomeBancoDados);

            // Consulta SQL para obter dados
            String consultaSQL = "SELECT * FROM usuarios";

            // Preparar a declaração SQL
            try (PreparedStatement statement = conexao.prepareStatement(consultaSQL)) {

                // Executar a consulta
                ResultSet resultSet = statement.executeQuery();

                // Criar o arquivo PDF
                try (FileOutputStream fos = new FileOutputStream(arquivoPDF);
                     Document document = new Document()) {

                    PdfWriter.getInstance(document, fos);
                    document.open();

                    // Adicionar conteúdo ao PDF
                    document.add(new Paragraph("Relatório de Usuários\n\n"));

                    // Adicionar os dados
                    while (resultSet.next()) {
                        String nome = resultSet.getString("Nome");
                        int idade = resultSet.getInt("Idade");
                        String email = resultSet.getString("Email");

                        document.add(new Paragraph("Nome: " + nome + ", Idade: " + idade + ", Email: " + email));
                    }

                    System.out.println("Arquivo PDF gerado com sucesso!");
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }

            // Fechar a conexão
            conexao.close();

        } catch (SQLException | java.io.IOException e) {
            e.printStackTrace();
        }
    } */
}
}
