package innovaetl;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.lambda.runtime.events.S3Event;

import java.io.*;
import java.util.List;

public class Main implements RequestHandler<S3Event, String> {

        private final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        private static final String DESTINATION_BUCKET = "innovaair-trusted";

        @Override
        public String handleRequest(S3Event s3Event, Context context) {

            String sourceBucket = s3Event.getRecords().get(0).getS3().getBucket().getName();
            String sourceKey = s3Event.getRecords().get(0).getS3().getObject().getKey();

            try {
                InputStream s3InputStream = s3Client.getObject(sourceBucket, sourceKey).getObjectContent();
                List<Dado> dados = Mapper.map(s3InputStream);
                dados = Ordenar.ordernarPorValorCapturadoPorMetrica(dados);
                InputStream csvInput = Mapper.demap(dados);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = csvInput.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                byte[] bytes = outputStream.toByteArray();
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentLength(bytes.length);
                metadata.setContentType("text/csv");
                String nomeDestino = "Trusted" + sourceKey.substring(sourceKey.lastIndexOf('d'));
                s3Client.putObject(DESTINATION_BUCKET, nomeDestino, new ByteArrayInputStream(bytes), metadata);

                return "Sucesso no processamento";
            } catch (Exception e) {
                context.getLogger().log("Erro: " + e.getMessage());
                return "Erro no processamento";
            }
        }
}
