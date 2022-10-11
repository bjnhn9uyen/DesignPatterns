package extra_DAOPattern_AbstractFactory.DAOs.MySQLDAOImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import extra_DAOPattern_AbstractFactory.BussinessObjects.Staff;
import extra_DAOPattern_AbstractFactory.DAOFactory.DAOFactory;
import extra_DAOPattern_AbstractFactory.DAOs.StaffDAO;

public class MySQLStaffDAO implements StaffDAO {

	@Override
	public void createTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement stmt = conn.createStatement();
		// We can use bit data type for gender, but not all database engines support bit data type.
		// Using char(1) data type for gender would make using of single natural characters "m", "f", etc...
		// versus the use of numeric data type which are referred to as surrogate/artificial characters.
		// And char data type is also supported on any database
		String sql = "create table staff (\n" + "id int auto_increment primary key,\n"
								+ "name nvarchar(30),\n" + "gender char(1),\n" + "age int,\n"
								+ "address nvarchar(50)\n" + ")";
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}

	@Override
	public void deleteTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("drop table staff");
		stmt.close();
		conn.close();
	}

	@Override
	public void addStaff(Staff staff) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement(
								"insert into staff(name, gender, age, address) values(?,?,?,?)");
		pStmt.setString(1, staff.getName());
		pStmt.setString(2, staff.getGender());
		pStmt.setInt(3, staff.getAge());
		pStmt.setString(4, staff.getAddress());
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

	@Override
	public List<Staff> getAllStaffs() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from staff");
		List<Staff> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new Staff(rs.getInt("id"), rs.getString("name"), rs.getString("gender"),
									rs.getInt("age"), rs.getString("address")));
		}
		rs.close();
		statement.close();
		conn.close();
		return list;
	}

	@Override
	public Staff getStaff(int id) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("select * from staff where id=?");
		pStmt.setInt(1, id);
		ResultSet rs = pStmt.executeQuery();
		Staff staff = null;
		if (rs.next()) {
			staff = new Staff(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), rs.getInt("age"),
									rs.getString("address"));
		}
		rs.close();
		pStmt.close();
		conn.close();
		return staff;
	}

	@Override
	public void updateStaff(Staff staff) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement(
								"update staff set name=? , gender=?, age=?, address=? where id=?");
		pStmt.setString(1, staff.getName());
		pStmt.setString(2, staff.getGender());
		pStmt.setInt(3, staff.getAge());
		pStmt.setString(4, staff.getAddress());
		pStmt.setInt(5, staff.getId());
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

	@Override
	public void deleteStaff(int id) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("delete from staff where id=?");
		pStmt.setInt(1, id);
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

}
