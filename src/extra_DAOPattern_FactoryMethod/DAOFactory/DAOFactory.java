package extra_DAOPattern_FactoryMethod.DAOFactory;

import java.sql.Connection;
import java.sql.SQLException;

import extra_DAOPattern_FactoryMethod.DAOs.BillDAO;
import extra_DAOPattern_FactoryMethod.DAOs.ProductDAO;
import extra_DAOPattern_FactoryMethod.DAOs.StaffDAO;

public abstract class DAOFactory {
	
	public abstract Connection connectDatabase() throws SQLException;
    
    public abstract void createDatabase() throws SQLException;
    
    public abstract void deleteDatabase() throws SQLException;
    
	public abstract ProductDAO getProductDAO();

	public abstract StaffDAO getStaffDAO();

	public abstract BillDAO getBillDAO();

	public static DAOFactory getDAOFactory() {
		return new SQLServerDAOFactory();
	}

}
