package extra_DAOPattern_FactoryMethod.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import extra_DAOPattern_FactoryMethod.DAOs.BillDAO;
import extra_DAOPattern_FactoryMethod.DAOs.ProductDAO;
import extra_DAOPattern_FactoryMethod.DAOs.StaffDAO;
import extra_DAOPattern_FactoryMethod.DAOs.DAOImplements.BillDAOImpl;
import extra_DAOPattern_FactoryMethod.DAOs.DAOImplements.ProductDAOImpl;
import extra_DAOPattern_FactoryMethod.DAOs.DAOImplements.StaffDAOImpl;

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
		return new ProductDAOImpl();
	}

	@Override
	public StaffDAO getStaffDAO() {
		return new StaffDAOImpl();
	}

	@Override
	public BillDAO getBillDAO() {
		return new BillDAOImpl();
	}

}
