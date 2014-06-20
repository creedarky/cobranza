package cl.acaya.business.service.ejb;

import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;
import cl.acaya.api.vo.ResumenInicialVO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by mcastro on 21-05-14.
 */

@Local
public interface CobranzaServiceLocal {

    ResumenInicialVO getCarteraPorTramos(List<Object[]> resultList);

    Response obtenerDocumentosSAP(Request request);

    Response getCargosSAP(Request request);
}
