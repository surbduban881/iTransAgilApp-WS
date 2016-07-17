package co.edu.udistrital.services;

import co.edu.udistrital.services.db.DBOperator;
import co.edu.udistrital.services.utils.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Método del servicio web que permite loguear el usuario
 *
 * @author Harold Stevens Espitia Paz
 */
@Path("OpLoginSession")
public class LoginUser {

    /**
     * Método para loguear un usuario en la aplicación
     *
     * @param email
     * @param password
     * @return Json con la respuesta
     */
    @GET
    public String loginUser(@QueryParam("email") String email, @QueryParam("password") String password) {
        String response = "";
        try {
            DBOperator dbo = new DBOperator();
            Map<String, String> responseElements = new HashMap<String, String>();
            ObjectMapper mapper = new ObjectMapper();

            String responseCode = dbo.logInUser(email, password);
            responseElements.put(Constants.RESPONSE_CODE, responseCode);
            responseElements.put(Constants.RESPONSE_MESSAGE, DBOperator.responseCodes.get(responseCode));

            response = mapper.writeValueAsString(responseElements);
            Logger.getLogger(LoginUser.class.getName()).log((Level.INFO),
                    "Request: [Email: " + email + " - Password: " + password + " ] + \n"
                    + "Response: " + response);
        } catch (IOException ex) {
            Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
