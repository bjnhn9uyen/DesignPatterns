package extra_DAOPattern_AbstractFactory.DAOFactory;

import java.sql.Connection;
import java.sql.SQLException;

import extra_DAOPattern_AbstractFactory.DAOFactory.ConcreteDAOFactories.MySQLDAOFactory;
import extra_DAOPattern_AbstractFactory.DAOFactory.ConcreteDAOFactories.SQLServerDAOFactory;
import extra_DAOPattern_AbstractFactory.DAOs.BillDAO;
import extra_DAOPattern_AbstractFactory.DAOs.ProductDAO;
import extra_DAOPattern_AbstractFactory.DAOs.StaffDAO;

public abstract class DAOFactory {

	// the concrete factories will implement these methods
	public abstract Connection connectDatabase() throws SQLException;

	public abstract void createDatabase() throws SQLException;

	public abstract void deleteDatabase() throws SQLException;

	public abstract ProductDAO getProductDAO();

	public abstract StaffDAO getStaffDAO();

	public abstract BillDAO getBillDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case 1:
			return new SQLServerDAOFactory();
		case 2:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}

}
