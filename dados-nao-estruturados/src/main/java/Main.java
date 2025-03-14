import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("pt-BR"));
        List<MaquinaMonitorada> maquinas = new ArrayList<>();
        MaquinaMonitorada maquina;

        for(int i = 0; i <= 10; i++) {
            maquina = new MaquinaMonitorada(
                    faker.company().name(),
                    faker.company().industry(),
                    faker.address().cityName(),
                    faker.number(),
                    faker.business().creditCardNumber(),
                    faker.name().fullName(),
                    faker.phoneNumber().cellPhone(),
                    faker.date()
            );
            maquinas.add(maquina);
        }

        for (int j = 0; j < maquinas.size(); j++) {
            System.out.println("Máquina #" + (j + 1));
            System.out.println(maquinas.get(j));
            System.out.println("----------------------------------");
        }
    }

}
