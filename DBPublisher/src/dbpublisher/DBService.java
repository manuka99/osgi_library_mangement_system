package dbpublisher;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * @author Manuka yasas
 *
 */
public interface DBService {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
}
