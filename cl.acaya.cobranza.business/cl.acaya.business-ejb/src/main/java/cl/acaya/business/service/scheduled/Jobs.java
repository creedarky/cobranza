package cl.acaya.business.service.scheduled;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.jobs.ee.ejb.EJB3InvokerJob;

/**
 * Created with IntelliJ IDEA.
 * User: fbrule
 * Date: 11/25/13
 * Time: 1:42 PM
 */
public class Jobs extends EJB3InvokerJob implements Job {

    private static final Logger LOGGER=Logger.getLogger(Jobs.class);

    @Override
    public void execute(JobExecutionContext context)throws JobExecutionException {

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("PCU-CRON::Proceso limpieza de negocios:: Iniciado");
        }
        /*
        JobDataMap dataMap = context.getMergedJobDataMap();
        dataMap.put(EJB_JNDI_NAME_KEY, "ejb.EliminaNegociosDiaAnteriorService#cl.entel.pcdc.postventa.api.services.EliminaNegociosDiaAnteriorServiceRemote");
        dataMap.put(EJB_METHOD_KEY, "eliminaNegociosDiaAnterior");
          */
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("PCU-CRON::Proceso limpieza de negocios:: Configurado");
        }

        super.execute(context);
    }
}
