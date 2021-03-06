package cl.acaya.cobranza.business.daoEjb.util;

import cl.acaya.api.vo.*;
import cl.acaya.cobranza.business.daoEjb.entities.*;
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
        //local.setFechaContable(documentoVO.getFechaContable());
        d.setFechaEmision(documentoVO.getFechaDocumento());
        d.setFechaVencimiento(documentoVO.getFechaVencimiento());
        d.setDocumentoCompensacion(documentoVO.getNumeroDocumentoCompensacion());
        d.setFechaCompensacion(documentoVO.getFechaCompensacion());
        d.setMontoDocumento(documentoVO.getMontoCobrar());
        d.setFacturaRelacionada(documentoVO.getFacturaRelacionada());
        d.setClavePago(documentoVO.getClavePago());
        d.setCodigoCobrador(documentoVO.getCodigoCobrador());
        d.setCodigoCuenta(documentoVO.getCodigoCuenta());
        d.setCodigoOperacion(documentoVO.getCodigoCuenta());
        d.setIndicadorCME(documentoVO.getIndicacionOperacion());
        d.setNumeroAsignacion(documentoVO.getNumeroAsignacion());
        d.setNumeroEjercicio(documentoVO.getNumeroEjercicio());
        d.setNumeroContable(documentoVO.getNumeroContable());
        d.setNumeroApunte(documentoVO.getNumeroApunte());
        d.setNombreResponsable(documentoVO.getNombreResponsable());
        d.setOficinaResponsable(documentoVO.getOficinaResponsable());
        d.setGrupoMateriales(documentoVO.getGrupoMateriales());
        d.setOrdenCompra(documentoVO.getOrdenCompra());

        // TODO por definir el resto de los campos
        return d;
    }

    public static Documento actualizar(Documento documentoOriginal, Documento documentoNuevo) {
        Documento d = new Documento();
        documentoOriginal.setNumeroFactura(documentoNuevo.getNumeroFactura());
        documentoOriginal.setNumeroDocumento(documentoNuevo.getNumeroFactura());
        documentoOriginal.setFolioSII(documentoNuevo.getFolioSII());
        documentoOriginal.setNumeroPedido(documentoNuevo.getNumeroPedido());
        //local.setFechaContable(documentoVO.getFechaContable());
        documentoOriginal.setFechaEmision(documentoNuevo.getFechaEmision());
        documentoOriginal.setFechaVencimiento(documentoNuevo.getFechaVencimiento());
        documentoOriginal.setDocumentoCompensacion(documentoNuevo.getDocumentoCompensacion());
        documentoOriginal.setFechaCompensacion(documentoNuevo.getFechaCompensacion());
        documentoOriginal.setMontoDocumento(documentoNuevo.getMontoDocumento());
        documentoOriginal.setFacturaRelacionada(documentoNuevo.getFacturaRelacionada());
        documentoOriginal.setLastUpdate(documentoNuevo.getLastUpdate());
        documentoOriginal.setFechaEmision(documentoNuevo.getFechaEmision());
        documentoOriginal.setFechaVencimiento(documentoNuevo.getFechaVencimiento());
        documentoOriginal.setDocumentoCompensacion(documentoNuevo.getDocumentoCompensacion());
        documentoOriginal.setFechaCompensacion(documentoNuevo.getFechaCompensacion());
        documentoOriginal.setMontoDocumento(documentoNuevo.getMontoDocumento());
        documentoOriginal.setFacturaRelacionada(documentoNuevo.getFacturaRelacionada());
        documentoOriginal.setClavePago(documentoNuevo.getClavePago());
        documentoOriginal.setCodigoCobrador(documentoNuevo.getCodigoCobrador());
        documentoOriginal.setCodigoCuenta(documentoNuevo.getCodigoCuenta());
        documentoOriginal.setCodigoOperacion(documentoNuevo.getCodigoCuenta());
        documentoOriginal.setIndicadorCME(documentoNuevo.getIndicadorCME());
        documentoOriginal.setNumeroAsignacion(documentoNuevo.getNumeroAsignacion());
        documentoOriginal.setNumeroEjercicio(documentoNuevo.getNumeroEjercicio());
        documentoOriginal.setNumeroContable(documentoNuevo.getNumeroContable());
        documentoOriginal.setNumeroApunte(documentoNuevo.getNumeroApunte());
        documentoOriginal.setNombreResponsable(documentoNuevo.getNombreResponsable());
        documentoOriginal.setOficinaResponsable(documentoNuevo.getOficinaResponsable());
        documentoOriginal.setGrupoMateriales(documentoNuevo.getGrupoMateriales());
        documentoOriginal.setOrdenCompra(documentoNuevo.getOrdenCompra());
        // TODO por definir el resto de los campos
        return documentoOriginal;
    }


    public static ClienteVO adaptar(Cliente cliente) {
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setIdCliente(cliente.getSystemId());
        clienteVO.setNombreCliente(cliente.getNombreCliente());
        clienteVO.setRutCliente(cliente.getRutCliente());
        clienteVO.setPedidosProceso(cliente.getPedidosEnProceso());
        clienteVO.setTipoSeguro(cliente.getTipoSeguro());
        clienteVO.setVigencia(cliente.getVigencia());
        clienteVO.setClasificacionRiesgo(cliente.getClasificacionRiesgo());
        clienteVO.setMontoSeguro(cliente.getMontoSeguro());
        clienteVO.setLineaCredito(cliente.getLineaCredito());
        clienteVO.setBloqueo(cliente.isBloqueo());
        clienteVO.setMontoSeguro(cliente.getMontoSeguro());
        clienteVO.setLineaCredito(cliente.getLineaCredito());
        clienteVO.setLineaCreditoUtilizada(cliente.getLineaCreditoUtilizada());
        clienteVO.setLineaCreditoDisponible(cliente.getLineaCreditoDisponible());
        clienteVO.setMontoSeguroUF(cliente.getMontoSeguroUF());
        clienteVO.setCanalVenta(cliente.getCanalVenta());
        clienteVO.setEstadoLinea(cliente.getEstadoLinea());
        clienteVO.setCondicioPago(cliente.getCondicionPago());
        return clienteVO;
    }

    public static UsuarioVO adaptar(Usuario usuario) {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setIdUsuario(usuario.getSystemId());
        usuarioVO.setNombreUsuario(usuario.getNombreCompleto());
        usuarioVO.setCorreoUsuario(usuario.getUsuarioEmail());
        return usuarioVO;
    }


    public static DocumentoVO adaptar(Documento documento) {
        DocumentoVO documentoVO = new DocumentoVO();
        documentoVO.setFechaEmision(documento.getFechaEmision());
        documentoVO.setFechaVencimiento(documento.getFechaVencimiento());
        documentoVO.setFechaCompensacion(documento.getFechaCompensacion());
        documentoVO.setMontoDocumento(documento.getMontoDocumento());
        documentoVO.setSaldoDocumento(documento.getSaldoDocumento());
        documentoVO.setEstadoDocumento(documento.isEstadoDocumento());
        documentoVO.setDespacho(documento.getDespacho());
        documentoVO.setSystemId(documento.getSystemId());
        documentoVO.setNumeroPedido(documento.getNumeroPedido());
        documentoVO.setNumeroFactura(documento.getNumeroFactura());
        documentoVO.setFolioSII(documento.getFolioSII());
        documentoVO.setDocumentoCompensacion(documento.getDocumentoCompensacion());
        documentoVO.setNumeroDocumento(documento.getNumeroDocumento());
        return documentoVO;
    }

    public static VendedorVO adaptar(Vendedor vendedor){
        VendedorVO vendedorVO = new VendedorVO();
        vendedorVO.setSystemId(vendedor.getSystemId());
        vendedorVO.setCodigoVendedor(vendedor.getCodigoVendedor());
        vendedorVO.setEmailVendedor(vendedor.getEmailVendedor());
        vendedorVO.setFonoVendedor1(vendedor.getFonoVendedor1());
        vendedorVO.setFonoVendedor2(vendedor.getFonoVendedor2());
        vendedorVO.setFonoVendedor3(vendedor.getFonoVendedor3());
        return vendedorVO;
    }

    public static SucursalVO adaptar(Sucursal sucursal){
        SucursalVO sucursalVO = new SucursalVO();
        sucursalVO.setSystemId(sucursal.getSystemId());
        sucursalVO.setCodigoSucursal(sucursal.getCodigoSucursal());
        sucursalVO.setNombreSucursal(sucursal.getNombreSucursal());
        return sucursalVO;
    }

    public static DmClienteVO adaptar(DmCliente dmCliente){
        DmClienteVO dmClienteVO = new DmClienteVO();
        dmClienteVO.setSystemId(dmCliente.getSystemId());
        dmClienteVO.setDmCliente(dmCliente.getDmCliente());

        return dmClienteVO;
    }

    public static TipoDocumentoVO adaptar(TipoDocumento tipoDocumento){
        TipoDocumentoVO tipoDocumentoVO = new TipoDocumentoVO();
        tipoDocumentoVO.setSystemId(tipoDocumento.getSystemId());
        tipoDocumentoVO.setCodigoTipo(tipoDocumento.getCodigoTipo());
        tipoDocumentoVO.setNombreTipo(tipoDocumento.getNombreTipo());
        return tipoDocumentoVO;
    }

    public static SociedadVO adaptar(Sociedad sociedad){
        SociedadVO sociedadVO = new SociedadVO();
        sociedadVO.setSystemId(sociedad.getSystemId());
        sociedadVO.setCodigoSociedad(sociedad.getCodigoSociedad());
        sociedadVO.setNombreSociedad(sociedad.getNombreSociedad());
        return sociedadVO;
    }

    public static ContactoVO adaptar(ContactoCliente contactoCliente) {
        ContactoVO contactoVO = new ContactoVO();
        contactoVO.setIdContacto(contactoCliente.getSystemId());
        contactoVO.setCargo(contactoCliente.getCargo().getCargoContacto());
        contactoVO.setIdCargo(contactoCliente.getCargo().getSystemId());
        contactoVO.setEmail(contactoCliente.getEmailContacto());
        contactoVO.setFono(contactoCliente.getFonoContacto1());
        contactoVO.setNombre(contactoCliente.getNombreContacto());
        return contactoVO;
    }

    public static AgendaVO adaptar(Agenda agenda) {
        AgendaVO agendaVO = new AgendaVO();
        agendaVO.setComentario(agenda.getComentario());
        agendaVO.setFechaAgendada(agenda.getFecAgenda());
        agendaVO.setIdAgenda(agenda.getSystemId());
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setNombreUsuario("Usuario Prueba");
        usuarioVO.setCorreoUsuario("usuario1@usuario.cl");
        agendaVO.setUsuarioVO(usuarioVO);
        return agendaVO;

    }

    public static BancoVO adaptar(Banco banco) {
        return new BancoVO(banco.getSystemId(), banco.getBanco());
    }

    public static FormaPagoVO adaptar(FormaPago formaPago) {
        return new FormaPagoVO(formaPago.getSystemId(),formaPago.getFormaPago(),formaPago.getDiasProm());
    }

    public static Recauda adaptar(RecaudaVO recaudaVO) {
        Recauda recauda = new Recauda();
        recauda.setEntregaCedible(recaudaVO.getEntregaCopia());
        recauda.setDireccion(recaudaVO.getDireccion());
        recauda.setFecPago(recaudaVO.getFecha());
        recauda.setPagoLun(recaudaVO.getPagoLun());
        recauda.setPagoMar(recaudaVO.getPagoMar());
        recauda.setPagoMie(recaudaVO.getPagoMie());
        recauda.setPagoJue(recaudaVO.getPagoJue());
        recauda.setPagoVie(recaudaVO.getPagoVie());
        recauda.setHorarioPago(recaudaVO.getHorarioPago());
        recauda.setInstrucciones(recaudaVO.getInstrucciones());
        return recauda;

    }

    public static CargoContactoVO adaptar(CargoContacto cargoContacto) {
        CargoContactoVO cargoContactoVO = new CargoContactoVO();
        cargoContactoVO.setIdCargo(cargoContacto.getSystemId());
        cargoContactoVO.setCargo(cargoContacto.getCargoContacto());
        return  cargoContactoVO;
    }



    public static HitoVO adaptar(Hitos hitos) {
        HitoVO hitoVO = new HitoVO();
        hitoVO.setEtapa(hitos.getEtapa());
        hitoVO.setFechaHito(hitos.getFechaHito());
        hitoVO.setContacto(TypesAdaptor.adaptar(hitos.getContacto()));
        hitoVO.setDocumento(TypesAdaptor.adaptar(hitos.getDocumento()));
        hitoVO.setUsuario(null);
        return hitoVO;
    }
}
