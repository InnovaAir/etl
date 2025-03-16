package Monitoramento;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Number;

public class MaquinaMonitorada {

    private String empresa;
    private Number maquinasMonitoradas;

    public MaquinaMonitorada (String empresa, Number maquinasMonitoradas) {
        this.empresa = empresa;
        this.maquinasMonitoradas = maquinasMonitoradas;

    }

    public String toString(){
        return "Empresa: " + empresa + "\n" +
                "Máquinas Monitoradas: " + maquinasMonitoradas;
    }

}

