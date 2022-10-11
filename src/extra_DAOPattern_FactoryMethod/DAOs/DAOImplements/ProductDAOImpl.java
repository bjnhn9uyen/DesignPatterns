package extra_DAOPattern_FactoryMethod.DAOs.DAOImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import extra_DAOPattern_FactoryMethod.BussinessObjects.Product;
import extra_DAOPattern_FactoryMethod.DAOFactory.DAOFactory;
import extra_DAOPattern_FactoryMethod.DAOs.ProductDAO;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void createTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory().connectDatabase();
		Statement stmt = conn.createStatement();
		String sqlQuery = "create table product (\n" + "id int identity(1, 1) primary key,\n"
								+ "name nvarchar(30),\n" + "price money\n" + ")";
		stmt.executeUpdate(sqlQuery);
		stmt.close();
		conn.close();
	}

	@Override
	public void deleteTable() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory().connectDatabase();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("drop table product");
		stmt.close();
		conn.close();
	}

	@Override
	public void addProduct(Product product) throws SQLException {
		Connection conn = DAOFactory.getDAOFactory().connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("insert into product(name, price) values(?,?)");
		pStmt.setString(1, product.getName());
		pStmt.setFloat(2, product.getPrice());
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		Connection conn = DAOFactory.getDAOFactory().connectDatabase();
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
		Connection conn = DAOFactory.getDAOFactory().connectDatabase();
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
		Connection conn = DAOFactory.getDAOFactory().connectDatabase();
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
		Connection conn = DAOFactory.getDAOFactory().connectDatabase();
		PreparedStatement pStmt = conn.prepareStatement("delete from product where id=?");
		pStmt.setInt(1, id);
		pStmt.executeUpdate();
		pStmt.close();
		conn.close();
	}

}
