package extra_DAOPattern_FactoryMethod.DAOs;

import java.sql.SQLException;
import java.util.List;

import extra_DAOPattern_FactoryMethod.BussinessObjects.Product;

public interface ProductDAO {

	void createTable() throws SQLException;

	void deleteTable() throws SQLException;

	void addProduct(Product product) throws SQLException;

	List<Product> getAllProducts() throws SQLException;

	Product getProduct(int id) throws SQLException;

	void updateProduct(Product product) throws SQLException;

	void deleteProduct(int id) throws SQLException;

}