package co.edu.udistrital.services.db;

/**
 * Contiene las configuraciones de la base de datos
 *
 * @author Harold Stevens Espitia Paz
 */
public class DBConnectionSettings {

    /**
     * Servidor
     */
    private String server;
    /**
     * Puerto
     */
    private String port;
    /**
     * Usuario
     */
    private String user;
    /**
     * Contrasena
     */
    private String password;
    /**
     * Nombre de base de datos
     */
    private String databaseName;
    /**
     * Cadena de conexión
     */
    private String connectionString;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getConnectionString() {
        if (this.connectionString == null) {
            this.connectionString = new StringBuilder("jdbc:sqlserver://")
                    .append(this.server)
                    .append(":")
                    .append(this.port)
                    .append(";databaseName=")
                    .append(this.databaseName)
                    .append(";user=")
                    .append(this.user)
                    .append(";password=")
                    .append(this.password)
                    .append(";").toString();
        }
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

}
