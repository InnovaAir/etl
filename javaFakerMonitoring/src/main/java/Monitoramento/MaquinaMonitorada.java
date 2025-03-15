package Monitoramento;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Number;

public class MaquinaMonitorada {

    private String empresa;
    private String setor;
    private String aeroporto;
    private Number maquinasMonitoradas;
    private String idMaquina;
    private String tecnicoResponsavel;
    private String contatoTecnico;
    private DateAndTime ultimaManutencao;

    public MaquinaMonitorada (String empresa, String setor, String aeroporto, Number maquinasMonitoradas, String idMaquina,
                              String tecnicoResponsavel, String contatoTecnico, DateAndTime ultimaManutencao) {
        this.empresa = empresa;
        this.setor = setor;
        this.aeroporto = aeroporto;
        this.maquinasMonitoradas = maquinasMonitoradas;
        this.idMaquina = idMaquina;
        this.tecnicoResponsavel = tecnicoResponsavel;
        this.contatoTecnico = contatoTecnico;
        this.ultimaManutencao = ultimaManutencao;

    }

    public String toString(){
        return "Empresa: " + empresa + "\n" +
                "Setor: " + setor + "\n" +
                "Aeroporto: " + aeroporto + "\n" +
                "Máquinas Monitoradas: " + maquinasMonitoradas + "\n" +
                "ID Máquina: " + idMaquina + "\n" +
                "Técnico Responsável: " + tecnicoResponsavel + "\n" +
                "Contato Técnico: " + contatoTecnico + "\n" +
                "Última Manutenção: " + ultimaManutencao;
    }

}

