package extra_DAOPattern_AbstractFactory.DAOFactory.ConcreteDAOFactories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import extra_DAOPattern_AbstractFactory.DAOFactory.DAOFactory;
import extra_DAOPattern_AbstractFactory.DAOs.BillDAO;
import extra_DAOPattern_AbstractFactory.DAOs.ProductDAO;
import extra_DAOPattern_AbstractFactory.DAOs.StaffDAO;
import extra_DAOPattern_AbstractFactory.DAOs.MySQLDAOImplements.MySQLBillDAO;
import extra_DAOPattern_AbstractFactory.DAOs.MySQLDAOImplements.MySQLProductDAO;
import extra_DAOPattern_AbstractFactory.DAOs.MySQLDAOImplements.MySQLStaffDAO;

public class MySQLDAOFactory extends DAOFactory {

	private static final String DB_URL = "jdbc:mysql://localhost/";
	private static final String DATABASENAME = "design_patterns";
	private static final String USER = "root";
	private static final String PASS = "admin";
	
	@Override
	public Connection connectDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL + DATABASENAME, USER, PASS);
		return conn;
	}

	@Override
	public void createDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("create database design_patterns");
		stmt.close();
		conn.close();
	}

	@Override
	public void deleteDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("drop database design_patterns");
		stmt.close();
		conn.close();
	}

	@Override
	public ProductDAO getProductDAO() {
		return new MySQLProductDAO();
	}

	@Override
	public StaffDAO getStaffDAO() {
		return new MySQLStaffDAO();
	}

	@Override
	public BillDAO getBillDAO() {
		return new MySQLBillDAO();
	}

}
