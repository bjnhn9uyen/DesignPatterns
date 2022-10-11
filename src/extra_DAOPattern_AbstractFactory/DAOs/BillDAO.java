package extra_DAOPattern_AbstractFactory.DAOs;

import java.sql.SQLException;
import java.util.List;

import extra_DAOPattern_AbstractFactory.BussinessObjects.Bill;

public interface BillDAO {

	void createTable() throws SQLException;

	void deleteTable() throws SQLException;

	void addBill(Bill bill) throws SQLException;

	List<Bill> getAllBills() throws SQLException;

	Bill getBill(int staffId, int productId) throws SQLException;

	void updateBill(Bill bill) throws SQLException;

	void deleteBill(int staffId, int productId) throws SQLException;

}
