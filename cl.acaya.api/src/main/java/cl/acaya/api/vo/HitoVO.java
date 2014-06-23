package cl.acaya.api.vo;

import cl.acaya.api.enums.EtapasDocumentoType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Maximiliano on 23/06/2014.
 */
public class HitoVO implements Serializable {

    private EtapasDocumentoType etapa;
    private Date fechaHito;
    private DocumentoVO documento;
    private UsuarioVO usuario;
    private ContactoVO contacto;

    public EtapasDocumentoType getEtapa() {
        return etapa;
    }

    public void setEtapa(EtapasDocumentoType etapa) {
        this.etapa = etapa;
    }

    public Date getFechaHito() {
        return fechaHito;
    }

    public void setFechaHito(Date fechaHito) {
        this.fechaHito = fechaHito;
    }

    public DocumentoVO getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoVO documento) {
        this.documento = documento;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public ContactoVO getContacto() {
        return contacto;
    }

    public void setContacto(ContactoVO contacto) {
        this.contacto = contacto;
    }


}
