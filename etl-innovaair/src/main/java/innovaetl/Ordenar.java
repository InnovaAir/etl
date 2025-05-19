package innovaetl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ordenar {
    public static List<Dado> ordenarPorValorCapturadoPorMetrica(List<Dado> dados){
        for (int i = 0; i < dados.size(); i ++){
            for (int j = i+1; j < dados.size(); j++){
                if (dados.get(j).getMetrica().compareTo(dados.get(i).getMetrica()) < 0){
                    Dado temp = dados.get(i);
                    dados.set(i, dados.get(j));
                    dados.set(j, temp);
                }
            }
        }
        for (int i = 0; i < dados.size(); i ++){
            String metricaAtual = dados.get(i).getMetrica();
            for (int j = i+1; j < dados.size(); j++){
            String metrica = dados.get(j).getMetrica();
            if(!metrica.equals(metricaAtual)){
                break;
            }
            if (dados.get(j).getValorCapturado() > dados.get(i).getValorCapturado()){
                Dado temp =  dados.get(i);
                dados.set(i, dados.get(j));
                dados.set(j, temp);
            }
            }
        }
        return dados;
    }

    public static List<Pix> ordenarPorValor(List<Pix> pixes){
        for (int i = 0; i < pixes.size(); i ++){
            for (int j = i+1; j < pixes.size(); j++){
                if (pixes.get(j).getVALOR().compareTo(pixes.get(i).getVALOR()) < 0){
                    Pix temp = pixes.get(i);
                    pixes.set(i, pixes.get(j));
                    pixes.set(j, temp);
                }
            }
        }
        return pixes;
    }
}
