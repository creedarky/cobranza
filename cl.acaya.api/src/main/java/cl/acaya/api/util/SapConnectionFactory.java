package cl.acaya.api.util;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.sap.Connect;
import cl.acaya.api.sap.SapSystem;

/**
 * Created by mcastro on 05-06-14.
 */
public final class SapConnectionFactory {

    public static Connect newConecction() {
        SapSystem system = new SapSystem(BusinessParameter.NAME_SAP, BusinessParameter.IP_SAP, BusinessParameter.CLIENTE_SAP,
                BusinessParameter.SYSTEM_NUMBER, BusinessParameter.USER_SAP, BusinessParameter.PASSWORD_SAP); //Conexion a sap
        Connect connect = new Connect(system);

        return connect;
    }
}
