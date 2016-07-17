package co.edu.udistrital.services;

import co.edu.udistrital.services.db.DBOperator;
import co.edu.udistrital.services.utils.Constants;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase que contiene las configuraciones del protocolo REST
 *
 * @author Harold Stevens Espitia Paz
 */
@ApplicationPath("/services")
public class RestConfiguration extends Application implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            String pathConfigFile = new StringBuilder(sce.getServletContext().getRealPath("")).append(Constants.PATH_PROPERTIES_FILE).toString();
            DBOperator.loadConfigurations(pathConfigFile);
        } catch (Exception ex) {
            Logger.getLogger(RestConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
