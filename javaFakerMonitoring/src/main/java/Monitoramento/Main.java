package Monitoramento;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Olá! Seja bem vindo ao acervo de dados da InnovaAir! Pressione o número desejado para: " +
                    "\n 1. Visualizar  de Filiais " +
                    "\n 2. Lista de componentes que monitoramos " +
                    "\n 3. Sair");
            Integer resultado = input.nextInt();

            if(resultado == 1){
                Faker faker = new Faker(new Locale("pt-BR"));
                List<MaquinaMonitorada> maquinas = new ArrayList<>();
                MaquinaMonitorada maquina;

                for(int i = 0; i < 10; i++) {
                    maquina = new MaquinaMonitorada(
                            faker.company().name(),
                            faker.company().industry(),
                            faker.address().cityName(),
                            faker.number(),
                            faker.idNumber().valid(),
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

            } else if (resultado == 2){
                while (true){
                    System.out.println("Abaixo, está uma lista de todos os componentes e informações que monitoramos. " +
                            "Pressione o número desejado para entender a importância deles diante do monitoramento: " +
                            "\n 1. CPU " +
                            "\n 2. memória RAM" +
                            "\n 3. Disco " +
                            "\n 4. Atividade de uso");
                    Integer resultado02 = input.nextInt();

                    if(resultado02 == 1){
                        System.out.println("CPU INFO");
                        break;
                    } else if(resultado02 == 2){
                        System.out.println("RAM INFO");
                        break;
                    } else if(resultado02 == 3){
                        System.out.println("Disco INFO");
                        break;
                    } else if(resultado02 == 4){
                        System.out.println("atvd de uso INFO");
                        break;
                    }
                }
            } else if(resultado == 3){
                break;
            }
        }
    }
}
