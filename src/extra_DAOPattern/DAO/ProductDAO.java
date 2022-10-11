package extra_DAOPattern.DAO;

import java.sql.SQLException;
import java.util.List;

import extra_DAOPattern.BussinessObject.Product;

public interface ProductDAO {

	void addProduct(Product product) throws SQLException;

	List<Product> getAllProducts() throws SQLException;

	Product getProduct(int id) throws SQLException;

	void updateProduct(Product product) throws SQLException;

	void deleteProduct(int id) throws SQLException;

}