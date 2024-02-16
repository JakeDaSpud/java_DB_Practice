import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO == Data Access Object
public class DAO {
    private String url = "jdbc:mysql://127.0.0.1/";
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

    //SHOULD BE PRIVATE
    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url + dbname, username, password);
                    return conn;
        }

        catch (SQLException e) {
            System.out.println("Unable to connect to database.");
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("Select * from Users");

        while (results.next()) {
            User u = new User();
            u.setId(results.getInt("ID"));
            u.setUsername(results.getString("username"));
            u.setPassword(results.getString("password"));
            u.setDisplayName(results.getString("displayName"));
            u.setAdmin(results.getInt("isAdmin") == 1);
            users.add(u);
        }

        conn.close();
        return users;
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
