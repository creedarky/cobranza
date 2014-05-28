package cl.acaya.api.vo;

import java.util.Date;

/**
 * Created by mcastro on 27-05-14.
 */
public class TramoVO {

    private String tramo;
    private Integer diaInicial;
    private Integer diaFinal;


    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public Integer getDiaInicial() {
        return diaInicial;
    }

    public void setDiaInicial(Integer diaInicial) {
        this.diaInicial = diaInicial;
    }

    public Integer getDiaFinal() {
        return diaFinal;
    }

    public void setDiaFinal(Integer diaFinal) {
        this.diaFinal = diaFinal;
    }
}
