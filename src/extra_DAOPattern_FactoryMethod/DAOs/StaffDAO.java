package extra_DAOPattern_FactoryMethod.DAOs;

import java.sql.SQLException;
import java.util.List;

import extra_DAOPattern_FactoryMethod.BussinessObjects.Staff;

public interface StaffDAO {

	void createTable() throws SQLException;

	void deleteTable() throws SQLException;

	void addStaff(Staff staff) throws SQLException;

	List<Staff> getAllStaffs() throws SQLException;

	Staff getStaff(int id) throws SQLException;

	void updateStaff(Staff staff) throws SQLException;

	void deleteStaff(int id) throws SQLException;

}
