package dbpublisher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Manuka yasas
 *
 */
public class DBServiceImpl implements DBService {
	
	private static Connection connection;

	// This works according to singleton pattern

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is
		 * null
		 */
		if (connection == null || connection.isClosed()) {
			Class.forName(Properties.DRIVER_NAME);
			connection = DriverManager.getConnection(Properties.URL, Properties.USERNAME, Properties.PASSWORD);
		}
		return connection;
	}

}
