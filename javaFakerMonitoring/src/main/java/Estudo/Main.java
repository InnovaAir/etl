package Estudo;

import java.util.Arrays;
import java.util.Scanner;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Faker faker = new Faker();

        int[] qtdMaquinas = {34, 25, 12, 22, 23, 28, 19};
        String[] componentes = {faker.company().name(), faker.company().name(), faker.company().name(), faker.company().name(),faker.company().name()};
        String[] filial = {"Aeroporto de Guarulhos", "Aeroporto de Congonhas", "Aeroporto Santos Dumont", "Aeroporto Galeão", "Aeroporto de Afonso Pena"};
        while (true){
            System.out.println("Olá! Seja bem vindo ao acervo de dados da InnovaAir! Pressione o número desejado para: " +
                    "\n 1. Lista de Filiais e Máquinas por Filial" +
                    "\n 2. Lista de companhias aéreas clientes" +
                    "\n 3. Sair");
            Integer resultado = input.nextInt();

            if (resultado == 1){
                Ordenacao.selectionSortOtimizado(qtdMaquinas);

                for (int i = 0; i < qtdMaquinas.length; i++) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Nome da Filial: " + faker.company().name());
                    System.out.println("Quantidade de Máquinas: " + qtdMaquinas[i]);
                }
            } else if (resultado == 2){
                Ordenacao.stringSort((componentes));

                for (int i = 0; i < componentes.length; i++) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Companhia: " + componentes[i]);
                    System.out.println("Nome da Filial: " + filial[i]);
                }
            } else if (resultado == 3){
                break;
            }
        }
    }
}