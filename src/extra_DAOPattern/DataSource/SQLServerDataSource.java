package extra_DAOPattern.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerDataSource {

	private static final String DB_URL = "jdbc:sqlserver://localhost;";
	private static final String DATABASENAME = "databaseName=design_patterns;";
	private static final String SECURE = "encrypt=true;trustServerCertificate=true;";
	private static final String USER = "user=sa;";
	private static final String PASS = "password=12345";

	// make this method static, so you can invoke it without an instance of this class
	public static Connection connectDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL + DATABASENAME + SECURE + USER + PASS);
		return conn;
	}

}
