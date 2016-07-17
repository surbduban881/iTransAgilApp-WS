package co.edu.udistrital.services.utils;

/**
 * Constantes usadas en la aplicación
 *
 * @author Harold Stevens Espitia Paz
 */
public abstract class Constants {

    /**
     * DRIVER SQLSERVER
     */
    public static String DRIVER_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    /**
     * Ruta de archivo properties
     */
    public static String PATH_PROPERTIES_FILE = "\\WEB-INF\\config.properties";
    /**
     * Nombre del servidor
     */
    public static String SERVER = "server";
    /**
     * Puerto de escucha de la base de datos
     */
    public static String PORT = "port";
    /**
     * Usuario
     */
    public static String USERNAME = "user";
    /**
     * Contrasena
     */
    public static String PASSWORD = "password";
    /**
     * Base de datos
     */
    public static String DATABASE_NAME = "databaseName";
    /**
     * Procedimiento almacenado: Registrar usuario
     */
    public static String SP_REGISTER_USER = "{ call RegisterUser (?, ?) }";
    /**
     * Procedimiento almacenado: Loguea usuario
     */
    public static String SP_LOGIN_USER = "{ call LogInUser (?, ?) }";
    /**
     * Procedimiento almacenado: Códigos de respuesta
     */
    public static String SP_GET_RESPONSE_CODES = "{ call GetResponseCodes }";
    /**
     * Código de respuesta
     */
    public static String RESPONSE_CODE = "responseCode";
    /**
     * Mensaje de respuesta
     */
    public static String RESPONSE_MESSAGE = "responseMessage";

}
