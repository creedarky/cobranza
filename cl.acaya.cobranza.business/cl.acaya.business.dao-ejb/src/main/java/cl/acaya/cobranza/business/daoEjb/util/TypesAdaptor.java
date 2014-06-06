package cl.acaya.cobranza.business.daoEjb.util;

import cl.acaya.api.vo.ClienteVO;
import cl.acaya.api.vo.PartidasSAPVO;
import cl.acaya.api.vo.UsuarioVO;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;
import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.entities.Usuario;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;

/**
 * Created by mcastro on 23-05-14.
 */
public class TypesAdaptor {

    public static final Logger LOGGER = Logger.getLogger(TypesAdaptor.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Documento adaptar(PartidasSAPVO documentoVO) {
        Documento d = new Documento();
        d.setNumeroFactura(documentoVO.getNumeroFactura());
        d.setNumeroDocumento(documentoVO.getNumeroFactura());
        d.setFolioSII(documentoVO.getFolioSii());
        d.setNumeroPedido(documentoVO.getOrdenCompra());
        //d.setFechaContable(documentoVO.getFechaContable());
        d.setFechaEmision(documentoVO.getFechaDocumento());
        d.setFechaVencimiento(documentoVO.getFechaVencimiento());
        d.setDocumentoCompensacion(documentoVO.getNumeroDocumentoCompensacion());
        d.setFechaCompensacion(documentoVO.getFechaCompensacion());
        d.setMontoDocumento(documentoVO.getMontoCobrar());
        // TODO por definir el resto de los campos
        return d;
    }

    public static ClienteVO adaptar(Cliente cliente) {
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setIdCliente(cliente.getSystemId());
        clienteVO.setNombreCliente(cliente.getNombreCliente());
        clienteVO.setRutCliente(cliente.getRutCliente());
        return clienteVO;
    }

    public static UsuarioVO adaptar(Usuario usuario) {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setIdUsuario(usuario.getSystemId());
        usuarioVO.setNombreUsuario(usuario.getNombreCompleto());
        usuarioVO.setCorreoUsuario(usuario.getUsuarioEmail());
        return usuarioVO;
    }


}
