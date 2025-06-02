package innovaetl;
import com.opencsv.bean.CsvBindByName;

public class Dado {
    @CsvBindByName
    private String terminal;
    @CsvBindByName
    private String setor;
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
    @CsvBindByName
    private String fkMetrica;

    public String getFkMetrica() {
        return fkMetrica;
    }

    public void setFkMetrica(String fkMetrica) {
        this.fkMetrica = fkMetrica;
    }

    public Dado(String terminal, String setor, Integer idMaquina, String componente, String especificacao, String metrica, Double valorCapturado, String momento, String fkMetrica) {
        this.terminal = terminal;
        this.setor = setor;
        this.idMaquina = idMaquina;
        this.componente = componente;
        this.especificacao = especificacao;
        this.metrica = metrica;
        this.valorCapturado = valorCapturado;
        this.momento = momento;
        this.fkMetrica = fkMetrica;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getSetor() { return setor; }

    public void setSetor(String setor) {
        this.setor = setor;
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

    public Dado(String terminal, String setor, Integer idMaquina, String componente, String especificacao, String metrica, Double valorCapturado, String momento) {
        this.terminal = terminal;
        this.setor = setor;
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
                "terminal='" + terminal + '\'' +
                ", setor=" + setor +
                ", idMaquina=" + idMaquina +
                ", componente='" + componente + '\'' +
                ", especificacao='" + especificacao + '\'' +
                ", metrica='" + metrica + '\'' +
                ", valorCapturado=" + valorCapturado +
                ", momento='" + momento + '\'' +
                '}';
    }
}
