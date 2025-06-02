package innovaetl;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.lambda.runtime.events.S3Event;

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
                LocalDateTime dataAtual = LocalDateTime.now();
                if (nomeArquivo.contains("data")){
                    List<Dado> dados = Mapper.map(s3InputStream);
                    Conexao conexao = new Conexao();
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statemxent.executeQuery("INSERT INTO CAPTURA_ALERTA VALUES ();");
                    conexao.closeConnection();
                }
                return "Sucesso no processamento";
            } catch (Exception e) {
                context.getLogger().log("Erro: " + e.getMessage());
                return "Erro no processamento";
            }
        }
}
