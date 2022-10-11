package extra_DAOPattern_AbstractFactory.DAOs.MySQLDAOImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import extra_DAOPattern_AbstractFactory.BussinessObjects.Product;
import extra_DAOPattern_AbstractFactory.DAOFactory.DAOFactory;
import extra_DAOPattern_AbstractFactory.DAOs.ProductDAO;

public class MySQLProductDAO implements ProductDAO {

	@Override
	public void createTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement stmt = conn.createStatement();
		// MySQL uses 'auto_increment' keyword instead of 'identity' as SQLServer
		// MySQL doesn't support 'money' data type as SQLServer, use decimal(15,2) instead
		// 15 is the total length of value including decimal places;
		// 2 is the number of digits after decimal point
		String sqlQuery = "create table product (\n" + "id int auto_increment primary key,\n"
								+ "name nvarchar(30),\n" + "price decimal(15,2)\n" + ")";
		stmt.executeUpdate(sqlQuery);
		stmt.close();
		conn.close();
	}

	@Override
	public void deleteTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("drop table product");
		stmt.close();
		conn.close();
	}

	@Override
	public void addProduct(Product product) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("insert into product(name, price) values(?,?)");
		pStmt.setString(1, product.getName());
		pStmt.setFloat(2, product.getPrice());
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from product");
		List<Product> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price")));
		}
		rs.close();
		statement.close();
		conn.close();
		return list;
	}

	@Override
	public Product getProduct(int id) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("select * from product where id=?");
		pStmt.setInt(1, id);
		ResultSet rs = pStmt.executeQuery();
		Product product = null;
		if (rs.next()) {
			product = new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"));
		}
		rs.close();
		pStmt.close();
		conn.close();
		return product;
	}

	@Override
	public void updateProduct(Product product) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("update product set name=? , price=? where id=?");
		pStmt.setString(1, product.getName());
		pStmt.setFloat(2, product.getPrice());
		pStmt.setInt(3, product.getId());
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

	@Override
	public void deleteProduct(int id) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory(2).connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("delete from product where id=?");
		pStmt.setInt(1, id);
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

}
