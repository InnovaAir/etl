package innovaetl;
import java.util.List;

public class TratarValorCapturado {
    public static List<Dado> tratarParaMB(List<Dado> dados) {
        for (Dado dado:dados){
            if(dado.getMetrica().equals("velocidadeDownload") || dado.getMetrica().equals("velocidadeUpload")){
                dado.setValorCapturado((double) Math.round(dado.getValorCapturado()/(1024*1024)));
            }
        }
        return dados;
    }

}
