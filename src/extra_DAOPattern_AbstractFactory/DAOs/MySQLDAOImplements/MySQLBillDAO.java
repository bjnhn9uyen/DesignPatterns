package extra_DAOPattern_AbstractFactory.DAOs.MySQLDAOImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import extra_DAOPattern_AbstractFactory.BussinessObjects.Bill;
import extra_DAOPattern_AbstractFactory.DAOFactory.DAOFactory;
import extra_DAOPattern_AbstractFactory.DAOs.BillDAO;

public class MySQLBillDAO implements BillDAO {

	@Override
	public void createTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement stmt = conn.createStatement();
		// bill's record uses the couple of staffId and productId for its unique identification
		String sql = "create table bill (\n" + "staffId int,\n" + "productId int,\n" + "quantitySold int,\n"
								+ "primary key (staffId, productId),\n"
								+ "foreign key (staffId) references staff(id),\n"
								+ "foreign key (productId) references product(id)\n" + ")";
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}

	@Override
	public void deleteTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("drop table bill");
		stmt.close();
		conn.close();
	}

	@Override
	public void addBill(Bill bill) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("insert into bill values(?,?,?)");
		pStmt.setInt(1, bill.getStaffId());
		pStmt.setInt(2, bill.getProductId());
		pStmt.setInt(3, bill.getQuantitySold());
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

	public List<Bill> getAllBills() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from bill");
		List<Bill> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new Bill(rs.getInt("staffId"), rs.getInt("productId"), rs.getInt("quantitySold")));
		}
		rs.close();
		statement.close();
		conn.close();
		return list;
	}

	@Override
	public Bill getBill(int staffId, int productId) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("select * from bill where staffId=?");
		pStmt.setInt(1, staffId);
		ResultSet rs = pStmt.executeQuery();
		List<Bill> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new Bill(rs.getInt("staffId"), rs.getInt("productId"), rs.getInt("quantitySold")));
		}
		for (Bill bill : list) {
			if (bill.getProductId() == productId) {
				rs.close();
				pStmt.close();
				conn.close();
				return bill;
			}
		}
		rs.close();
		pStmt.close();
		conn.close();
		return null;
	}

	@Override
	public void updateBill(Bill bill) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement(
								"update bill set quantitySold=? where staffId=? and productId=?");
		pStmt.setInt(1, bill.getQuantitySold());
		pStmt.setInt(2, bill.getStaffId());
		pStmt.setInt(3, bill.getProductId());
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

	@Override
	public void deleteBill(int staffId, int productId) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("delete from bill where staffId=? and productId=?");
		pStmt.setInt(1, staffId);
		pStmt.setInt(2, productId);
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

}
