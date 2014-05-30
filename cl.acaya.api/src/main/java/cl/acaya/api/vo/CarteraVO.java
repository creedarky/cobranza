package cl.acaya.api.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mcastro on 27-05-14.
 */
public class CarteraVO {

    private Long id;
    private ClienteVO cliente;
    private String alDia;
    private String total;
    private List<TramoVO> tramosList = new ArrayList<TramoVO>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public String getAlDia() {
        return alDia;
    }

    public void setAlDia(String alDia) {
        this.alDia = alDia;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<TramoVO> getTramosList() {
        return tramosList;
    }

    public void setTramosList(List<TramoVO> tramosList) {
        this.tramosList = tramosList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarteraVO carteraVO = (CarteraVO) o;

        if (cliente != null ? !cliente.equals(carteraVO.cliente) : carteraVO.cliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cliente != null ? cliente.hashCode() : 0;
    }
}
