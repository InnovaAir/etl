package Monitoramento;

public class Ordenacao {

    public static void selectionSort (int[] v) {

        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[i]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
    }
    public static void stringSort(String[] v) {

        int n = v.length;

        for (int i = 0; i < n - 1; i++) {
            int menorIndice = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j].compareTo(v[menorIndice]) < 0) {
                    menorIndice = j;
                }
            }
            String aux = v[i];
            v[i] = v[menorIndice];
            v[menorIndice] = aux;
        }
    }
}
