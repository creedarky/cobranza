package cl.acaya.cobranza.business.daoEjb.util;

import cl.acaya.api.vo.DocumentoVO;
import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;

/**
 * Created by mcastro on 23-05-14.
 */
public class TypesAdaptor {

        public static final Logger LOGGER = Logger.getLogger(TypesAdaptor.class);
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        public static Documento adaptar(DocumentoVO documentoVO) {
            Documento d = new Documento();
            d.setNumeroFactura(documentoVO.getNumeroFactura());
            d.setNumeroDocumento(documentoVO.getNumeroFactura());
            d.setFolioSII(documentoVO.getFolioSii());
            d.setNumeroPedido(documentoVO.getOrdenCompra());
            d.setFechaContable(documentoVO.getFechaContable());
            d.setFechaEmision(documentoVO.getFechaDocumento());
            d.setFechaVencimiento(documentoVO.getFechaVencimiento());
            d.setDocumentoCompensacion(documentoVO.getNumeroDocumentoCompensacion());
            d.setFechaCompensacion(documentoVO.getFechaCompensacion());
            d.setMontoDocumento(documentoVO.getMontoCobrar());
            // TODO por definir el resto de los campos
            return d;
        }
}
