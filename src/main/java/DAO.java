import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DAO == Data Access Object
public class DAO {
    private String url = "jdbc:mysql://localhost/";
    private String dbname = "test";
    private String username = "root";
    private String password = "";

    private static DAO instance;

    private DAO() {

    }

    public static DAO getInstance() {
        //if no instance, instantiate it
        if (instance == null)
            instance = new DAO();

        //otherwise return the only instance
        return instance;
    };

    private Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url + dbname, username, password);
                    return conn;
        }

        catch (SQLException e) {
            System.out.println("Unable to connect to database.");
            return null;
        }
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDbname() {
        return dbname;
    }
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
