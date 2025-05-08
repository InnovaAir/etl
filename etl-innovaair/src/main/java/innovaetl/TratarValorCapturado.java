package innovaetl;
import java.util.List;

public class TratarValorCapturado {
    public static List<Dado> tratarParaMB(List<Dado> dados) {
        for (Dado dado:dados){
            if(dado.getMetrica().equals("velocidadeDownload") || dado.getMetrica().equals("velocidadeUpload")){
                dado.setValorCapturado(Math.round(dado.getValorCapturado()/1024**2));
            }
        }
        return dados;
    }

}
