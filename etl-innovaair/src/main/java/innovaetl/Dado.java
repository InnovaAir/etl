package innovaetl;
import com.opencsv.bean.CsvBindByName;

public class Dado {
    @CsvBindByName
    private String razaoSocial;
    @CsvBindByName
    private Integer idFilial;
    @CsvBindByName
    private Integer idMaquina;
    @CsvBindByName
    private String componente;
    @CsvBindByName
    private String especificacao;
    @CsvBindByName
    private String metrica;
    @CsvBindByName
    private Double valorCapturado;
    @CsvBindByName
    private String momento;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Integer getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(Integer idFilial) {
        this.idFilial = idFilial;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getMetrica() {
        return metrica;
    }

    public void setMetrica(String metrica) {
        this.metrica = metrica;
    }

    public Double getValorCapturado() {
        return valorCapturado;
    }

    public void setValorCapturado(Double valorCapturado) {
        this.valorCapturado = valorCapturado;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }

    public Dado(String razaoSocial, Integer idFilial, Integer idMaquina, String componente, String especificacao, String metrica, Double valorCapturado, String momento) {
        this.razaoSocial = razaoSocial;
        this.idFilial = idFilial;
        this.idMaquina = idMaquina;
        this.componente = componente;
        this.especificacao = especificacao;
        this.metrica = metrica;
        this.valorCapturado = valorCapturado;
        this.momento = momento;
    }

    public Dado() {
    }

    @Override
    public String toString() {
        return "Dado{" +
                "razaoSocial='" + razaoSocial + '\'' +
                ", idFilial=" + idFilial +
                ", idMaquina=" + idMaquina +
                ", componente='" + componente + '\'' +
                ", especificacao='" + especificacao + '\'' +
                ", metrica='" + metrica + '\'' +
                ", valorCapturado=" + valorCapturado +
                ", momento='" + momento + '\'' +
                '}';
    }
}
