package cl.acaya.web.models;

import cl.acaya.api.vo.AgendaVO;
import cl.acaya.api.vo.CampanhaVO;
import cl.acaya.api.vo.CarteraVO;
import cl.acaya.api.vo.TramoVO;

import java.util.List;

/**
 * Created by mcastro on 27-05-14.
 */
public class PantallaInicialModel
{

    private List<AgendaVO> agendaVOList;
    private List<CampanhaVO> campanhaVOList;
    private List<TramoVO> tramoVOList;
    private List<CarteraVO> carteraVOList;


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

    public List<TramoVO> getTramoVOList() {
        return tramoVOList;
    }

    public void setTramoVOList(List<TramoVO> tramoVOList) {
        this.tramoVOList = tramoVOList;
    }

    public List<CarteraVO> getCarteraVOList() {
        return carteraVOList;
    }

    public void setCarteraVOList(List<CarteraVO> carteraVOList) {
        this.carteraVOList = carteraVOList;
    }
}
