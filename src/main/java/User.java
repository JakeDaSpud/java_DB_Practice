/*
    id int not null auto_increment primary key,
    username char(40),
    password char(20),
    displayName char(),
    isAdmin boolean
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String displayName;
    private boolean isAdmin;

    public User(int id, String username, String password, String displayName, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", displayName='" + displayName + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
