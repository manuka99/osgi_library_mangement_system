package DB;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBService {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
}
