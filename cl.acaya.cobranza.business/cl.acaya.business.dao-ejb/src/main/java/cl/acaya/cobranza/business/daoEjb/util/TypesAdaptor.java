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
            d.setMontoDocumento(documentoVO.getMontoCobrar());
            d.setNumeroDocumento(documentoVO.getNumeroDocumento());
            d.setFechaEmision(documentoVO.getFechaDocumento());
            d.setFechaCompensacion(documentoVO.getFechaCompensacion());
            d.setFechaVencimiento(documentoVO.getFechaVencimiento());
            // TODO por definir el resto de los campos
            return d;
        }
}
