package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/petpals";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; 

    public static Connection getConnection() throws SQLException {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

	public static Connection getConnection(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
