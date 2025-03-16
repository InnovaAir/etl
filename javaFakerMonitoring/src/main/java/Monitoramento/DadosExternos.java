package Monitoramento;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DadosExternos {

        static Faker faker = new com.github.javafaker.Faker(new Locale("pt-BR"));

    public static void criarLista() {
        List<MaquinaMonitorada> maquinas = new ArrayList<>();
        MaquinaMonitorada maquina;

        for (int i = 0; i < 10; i++) {
            maquina = new MaquinaMonitorada(
                    faker.company().name(),
                    faker.number()
            );
            maquinas.add(maquina);
        }
    }
}
