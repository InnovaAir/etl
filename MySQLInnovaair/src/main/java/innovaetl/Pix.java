package innovaetl;
import com.opencsv.bean.CsvBindByName;

public class Pix {
    @CsvBindByName
    private String AnoMes;
    @CsvBindByName
    private Double VALOR;
    @CsvBindByName
    private Integer QUANTIDADE;

    public Pix(String anoMes, Double VALOR, Integer QUANTIDADE) {
        AnoMes = anoMes;
        this.VALOR = VALOR;
        this.QUANTIDADE = QUANTIDADE;
    }

    public Pix() {
    }

    public String getAnoMes() {
        return AnoMes;
    }

    public void setAnoMes(String anoMes) {
        AnoMes = anoMes;
    }

    public Double getVALOR() {
        return VALOR;
    }

    public void setVALOR(Double VALOR) {
        this.VALOR = VALOR;
    }

    public Integer getQUANTIDADE() {
        return QUANTIDADE;
    }

    public void setQUANTIDADE(Integer QUANTIDADE) {
        this.QUANTIDADE = QUANTIDADE;
    }
}
