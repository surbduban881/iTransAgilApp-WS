/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author hespitia
 */
@Path("OpRegisterUser")
public class RegisterUser {

    /**
     * Método del servicio web, para registrar un usuario
     *
     * @param user
     * @param password
     * @return Json con la respuesta
     */
    @GET
    public String registerUser(@QueryParam("email") String user, @QueryParam("password") String password) {
        String response = "";
        try {
            DBOperator dbo = new DBOperator();
            Map<String, String> responseElements = new HashMap<String, String>();
            ObjectMapper mapper = new ObjectMapper();

            String responseCode = dbo.registerUser(user, password);
            responseElements.put(Constants.RESPONSE_CODE, responseCode);
            responseElements.put(Constants.RESPONSE_MESSAGE, DBOperator.responseCodes.get(responseCode));

            response = mapper.writeValueAsString(responseElements);
        } catch (IOException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}
