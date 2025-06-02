package innovaetl;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.lambda.runtime.events.S3Event;

import javax.print.DocFlavor;
import java.io.*;
import java.sql.*;
import java.util.List;
import java.time.LocalDateTime;

public class Main implements RequestHandler<S3Event, String> {

        private final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        private static final String DESTINATION_BUCKET = "clients311";

        @Override
        public String handleRequest(S3Event s3Event, Context context) {

            String sourceBucket = s3Event.getRecords().get(0).getS3().getBucket().getName();
            String sourceKey = s3Event.getRecords().get(0).getS3().getObject().getKey();

            try {
                InputStream csvInput = null;
                String nomeDestino = null;
                InputStream s3InputStream = s3Client.getObject(sourceBucket, sourceKey).getObjectContent();
                String nomeArquivo = s3Event.getRecords().get(0).getS3().getObject().getKey();
                if (nomeArquivo.contains("data")){
                    List<Dado> dados = Mapper.map(s3InputStream);
                    String url = "jdbc:mysql://10.18.32.178:3306/innovaair"; // Substitua pelos seus dados
                    String user = "innova_admin";
                    String password = "Innovaair@123";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, user, password);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = null;
                    for (Dado dado:dados){
                        String insert = String.format("INSERT INTO captura_alerta (momento, valorCapturado, fkMetrica) VALUES ('%s', %f, %d);", dado.getMomento(), dado.getValorCapturado(), dado.getFkMetrica());
                        int primeiro = insert.indexOf(",");
                        int segundo = insert.indexOf(",", primeiro+1);
                        int terceiro = insert.indexOf(",", segundo+1);
                        int quarto = insert.indexOf(",", terceiro+1);
                        System.out.println(quarto);
                        StringBuilder stringBuilder = new StringBuilder(insert);
                        stringBuilder.setCharAt(quarto, '.');
                        System.out.println(stringBuilder);
                        statement.executeUpdate(String.valueOf(stringBuilder));
                    }
                    statement.close();
                    connection.close();
                }
                return "Sucesso no processamento";
            } catch (Exception e) {
                context.getLogger().log("Erro: " + e.getMessage());
                return "Erro no processamento";
            }
        }
}
