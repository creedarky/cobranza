package cl.acaya.api.vo;

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
    private List<String> tramosList;


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

    public List<String> getTramosList() {
        return tramosList;
    }

    public void setTramosList(List<String> tramosList) {
        this.tramosList = tramosList;
    }
}
