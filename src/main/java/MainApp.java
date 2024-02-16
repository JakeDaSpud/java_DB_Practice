import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        DAO.getInstance().getConnection();

        String uName, pass;
        Scanner in = new Scanner(System.in);
        System.out.println("Username: ");
        uName = in.nextLine();
        System.out.println("Password: ");
        pass = in.next();

        DAO dao = DAO.getInstance();
        //User u = dao.LogIn(uName, pass);

        if (u == null) {
            System.out.println("Login Failed.");
        }

        else {
            System.out.println("Welcome back " + u.getDisplayName);

            System.out.println("Current Users: ");
            List<User> all = dao.getAllUsers();
            System.out.printf("%-5d %-15s %-15s %-15s %-5s", "ID", "Username", "Password", "Display Name", "Admin");

            for (User u : all) {
                System.out.printf("%-5d %-15s %-15s %-15s %-5s", u.getId(), u.getUsername(), u.getPassword(), u.getDisplayName(), u.isAdmin() ? "Yes":"No");
            }
        }
    }
}
