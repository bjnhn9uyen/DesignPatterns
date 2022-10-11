package extra_DAOPattern_AbstractFactory.DAOFactory.ConcreteDAOFactories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import extra_DAOPattern_AbstractFactory.DAOFactory.DAOFactory;
import extra_DAOPattern_AbstractFactory.DAOs.BillDAO;
import extra_DAOPattern_AbstractFactory.DAOs.ProductDAO;
import extra_DAOPattern_AbstractFactory.DAOs.StaffDAO;
import extra_DAOPattern_AbstractFactory.DAOs.SQLServerDAOImplements.SQLServerBillDAO;
import extra_DAOPattern_AbstractFactory.DAOs.SQLServerDAOImplements.SQLServerProductDAO;
import extra_DAOPattern_AbstractFactory.DAOs.SQLServerDAOImplements.SQLServerStaffDAO;

public class SQLServerDAOFactory extends DAOFactory {

	private static final String DB_URL = "jdbc:sqlserver://localhost;";
	private static final String DATABASENAME = "databaseName=design_patterns;";
	private static final String SECURE = "encrypt=true;trustServerCertificate=true;";
	private static final String USER = "user=sa;";
	private static final String PASS = "password=12345";

	@Override
	public Connection connectDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL + DATABASENAME + SECURE + USER + PASS);
		return conn;
	}

	@Override
	public void createDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL + SECURE + USER + PASS);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("create database design_patterns");
		stmt.close();
		conn.close();
	}

	@Override
	public void deleteDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL + SECURE + USER + PASS);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("drop database design_patterns");
		stmt.close();
		conn.close();
	}

	@Override
	public ProductDAO getProductDAO() {
		return new SQLServerProductDAO();
	}

	@Override
	public StaffDAO getStaffDAO() {
		return new SQLServerStaffDAO();
	}

	@Override
	public BillDAO getBillDAO() {
		return new SQLServerBillDAO();
	}

}
