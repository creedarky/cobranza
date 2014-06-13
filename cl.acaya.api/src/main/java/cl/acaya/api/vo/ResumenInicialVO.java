package cl.acaya.api.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by mcastro on 27-05-14.
 */
public class ResumenInicialVO {

    private List<TramoVO> tramoVOList;
    private List<CarteraVO> carteraVOList;
    private List<AgendaVO> agendaVOList;
    private List<CampanhaVO> campanhaVOList;
    private List<ContingenciaVO> contingenciaVOList;

    public List<TramoVO> getTramoVOList() {
        return tramoVOList;
    }

    public void setTramoVOList(List<TramoVO> tramoVOList) {
        this.tramoVOList = tramoVOList;
    }

    public List<ContingenciaVO> getContingenciaVOList() {
        return contingenciaVOList;
    }

    public void setContingenciaVOList(List<ContingenciaVO> contingenciaVOList) {
        this.contingenciaVOList = contingenciaVOList;
    }

    public List<CarteraVO> getCarteraVOList() {
        return carteraVOList;
    }

    public void setCarteraVOList(List<CarteraVO> carteraVOList) {
        this.carteraVOList = carteraVOList;
    }

    public List<AgendaVO> getAgendaVOList() {
        return agendaVOList;
    }

    public void setAgendaVOList(List<AgendaVO> agendaVOList) {
        this.agendaVOList = agendaVOList;
    }

    public List<CampanhaVO> getCampanhaVOList() {
        return campanhaVOList;
    }

    public void setCampanhaVOList(List<CampanhaVO> campanhaVOList) {
        this.campanhaVOList = campanhaVOList;
    }
}
