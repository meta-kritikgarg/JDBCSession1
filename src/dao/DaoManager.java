package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Kritik Garg
 *
 */

/*
 * Class to get connection for database (Singleton pattern )
 */
public class DaoManager {

	private static DaoManager instance = new DaoManager();

	public static final String URL = "jdbc:mysql://localhost/libraryinformationsystem";
	public static final String USER = "root";
	public static final String PASSWORD = "12345";

	// Constructor
	private DaoManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// To create connection
	private Connection createConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * To get object of connection for database
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		return instance.createConnection();
	}

}
