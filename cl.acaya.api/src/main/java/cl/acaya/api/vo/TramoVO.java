package cl.acaya.api.vo;

import java.util.Date;

/**
 * Created by mcastro on 27-05-14.
 */
public class TramoVO {

    private String tramo;
    private Integer diaInicial;
    private Integer diaFinal;
    private Integer diaMenor;
    private String monto;

    public TramoVO() {
        monto = "0";
    }

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

    public Integer getDiaMenor() {
        return diaMenor;
    }

    public void setDiaMenor(Integer diaMenor) {
        this.diaMenor = diaMenor;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public TramoVO clone() throws CloneNotSupportedException {
        TramoVO tramoVO = new TramoVO();
        tramoVO.setTramo(tramo);
        tramoVO.setDiaInicial(diaInicial);
        tramoVO.setDiaFinal(diaFinal);
        tramoVO.setDiaMenor(diaMenor);
        return tramoVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TramoVO tramoVO = (TramoVO) o;

        if (tramo != null ? !tramo.equals(tramoVO.tramo) : tramoVO.tramo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tramo != null ? tramo.hashCode() : 0;
    }
}
