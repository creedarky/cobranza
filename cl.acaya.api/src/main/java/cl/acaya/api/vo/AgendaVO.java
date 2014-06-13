package cl.acaya.api.vo;

import java.util.Date;

/**
 * Created by mcastro on 27-05-14.
 */
public class AgendaVO {

    private ClienteVO cliente;
    private Date fechaAgendada;
    private String comentario;
    private Integer idAgenda;
    private UsuarioVO usuarioVO;


    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public Date getFechaAgendada() {
        return fechaAgendada;
    }

    public void setFechaAgendada(Date fechaAgendada) {
        this.fechaAgendada = fechaAgendada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
}
