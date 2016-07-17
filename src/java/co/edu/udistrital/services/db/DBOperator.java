package co.edu.udistrital.services.db;

import co.edu.udistrital.services.utils.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Realiza la conexión y operaciones a la base dze datos
 *
 * @author Harold Stevens Espitia Paz
 */
public class DBOperator {

    /**
     * Obnjeto de conexión a la base de datos
     */
    private static Connection connection;
    /**
     * Configuraciones de la base de datos
     */
    private static DBConnectionSettings connectionSettings;
    /**
     * Códigos de Respuesta
     */
    public static Map<String, String> responseCodes;

    /**
     * Inicializa las propiedades de conexión a la base de datos.
     * @param pathFile 
     */
    public static void loadConfigurations(String pathFile) {
        try {
            Properties prop = new Properties();
            File file = new File(pathFile);
            InputStream stream = new FileInputStream(file);
            prop.load(stream);

            connectionSettings = new DBConnectionSettings();
            connectionSettings.setServer(prop.getProperty(Constants.SERVER));
            connectionSettings.setPort(prop.getProperty(Constants.PORT));
            connectionSettings.setUser(prop.getProperty(Constants.USERNAME));
            connectionSettings.setPassword(prop.getProperty(Constants.PASSWORD));
            connectionSettings.setDatabaseName(prop.getProperty(Constants.DATABASE_NAME));

            responseCodes = getResponseCodes();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Obtiene la conexión a la base de datos
     *
     * @return
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(Constants.DRIVER_SQLSERVER);
                connection = DriverManager.getConnection(connectionSettings.getConnectionString());
            } catch (ClassNotFoundException | SQLException cnfe) {
                java.util.logging.Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, cnfe);
            }
        }
        return connection;
    }

    /**
     * Carga los códigos de respuesta de la base de datos
     *
     * @return
     */
    private static Map<String, String> getResponseCodes() {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        Map<String, String> responseCodesInner = null;
        try {
            cStmt = getConnection().prepareCall(Constants.SP_GET_RESPONSE_CODES);
            cStmt.execute();
            rs = cStmt.getResultSet();
            responseCodesInner = new HashMap<String, String>();
            while (rs.next()) {
                responseCodesInner.put(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            try {
                cStmt.close();
                rs.close();
                Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return responseCodesInner;
    }

    /**
     * Permite registrar un usuario en la base de datos
     *
     * @param user
     * @param password
     * @return codigo de respuesta
     */
    public String registerUser(String user, String password) {
        String responseCode = "";
        CallableStatement cStmt = null;
        ResultSet rs = null;
        try {
            cStmt = getConnection().prepareCall(Constants.SP_REGISTER_USER);
            cStmt.setString(1, user);
            cStmt.setString(2, password);
            cStmt.execute();

            rs = cStmt.getResultSet();
            while (rs.next()) {
                responseCode = rs.getString(1);
            }
        } catch (SQLException ex) {
            try {
                cStmt.close();
                rs.close();
                Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return responseCode;
    }

    /**
     * Ejecuta el proceso de verificación de credenciales en la base de datos
     *
     * @param user
     * @param password
     * @return
     */
    public String logInUser(String user, String password) {
        String responseCode = "";
        CallableStatement cStmt = null;
        ResultSet rs = null;
        try {
            cStmt = getConnection().prepareCall(Constants.SP_LOGIN_USER);
            cStmt.setString(1, user);
            cStmt.setString(2, password);
            cStmt.execute();

            rs = cStmt.getResultSet();
            while (rs.next()) {
                responseCode = rs.getString(1);
            }
        } catch (SQLException ex) {
            try {
                cStmt.close();
                rs.close();
                Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DBOperator.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return responseCode;
    }
}
