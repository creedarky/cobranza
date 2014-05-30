package cl.acaya.cobranza.business.daoEjb.util.comparator;

import cl.acaya.api.vo.TramoVO;

import java.util.Comparator;

/**
 * Created by mcastro on 30-05-14.
 */
public class TramoVOComparator implements Comparator<TramoVO> {

    public int compare(TramoVO a, TramoVO b) {
        return a.getDiaMenor().compareTo(b.getDiaMenor());
    }
}
