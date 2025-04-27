package innovaetl;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.CSVWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.*;
import java.util.List;

public class Mapper {
    public static List<Dado> map(InputStream inputStream) throws IOException{
        InputStreamReader leitor = new InputStreamReader(inputStream);
        CsvToBean<Dado> csvToBean = new CsvToBeanBuilder<Dado>(leitor)
                .withType(Dado.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.parse();
    }

    public static InputStream demap(List<Dado> dados) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStreamWriter gravador = new OutputStreamWriter(outputStream);

        StatefulBeanToCsv<Dado> beanToCsv = new StatefulBeanToCsvBuilder<Dado>(gravador)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        beanToCsv.write(dados);
        gravador.flush();
        gravador.close();

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    public static void salvarArquivoTemp(InputStream inputStream) throws IOException {
        File tempFile = new File("temp.csv");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Arquivo temporário gerado em: " + tempFile.getAbsolutePath());
        }
    }
}
