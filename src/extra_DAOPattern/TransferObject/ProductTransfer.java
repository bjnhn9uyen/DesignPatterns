package extra_DAOPattern.TransferObject;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import extra_DAOPattern.BussinessObject.Product;
import extra_DAOPattern.DAO.ProductDAO;
import extra_DAOPattern.DAO.ProductDAOImpl;

public class ProductTransfer {

	private ProductDAO productDAO = new ProductDAOImpl();

	public void createProduct(Scanner scanner) throws SQLException {
		System.out.println("Input information for product:");
		try {
			System.out.print("Name: ");
			String name = scanner.next();
			System.out.print("Price: ");
			Float price = scanner.nextFloat();
			productDAO.addProduct(new Product(0, name, price));
			pressEnterToContinue(scanner, "New product added successfully!");
		} catch (InputMismatchException e) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	public void readAllProducts(Scanner scanner) throws SQLException {
		List<Product> list = productDAO.getAllProducts();
		if (list.isEmpty()) {
			pressEnterToContinue(scanner, "Product list is empty!");
		} else {
			System.out.println("Product list:");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("\tProduct " + (i + 1) + ": ");
				System.out.println(list.get(i));
			}
			pressEnterToContinue(scanner, "");
		}
	}

	public void updateProduct(Scanner scanner) throws SQLException {
		System.out.print("Enter product's id to update product: ");
		try {
			int id = scanner.nextInt();
			if (productDAO.getProduct(id) == null) {
				pressEnterToContinue(scanner, "Id '" + id + "' does not exist!");
			} else {
				System.out.print("set name: ");
				String name = scanner.next();
				System.out.print("set price: ");
				Float price = scanner.nextFloat();
				productDAO.updateProduct(new Product(id, name, price));
				pressEnterToContinue(scanner, "Product '" + id + "' updated successfully!");
			}
		} catch (InputMismatchException e) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	public void deleteProduct(Scanner scanner) throws SQLException {
		System.out.print("Enter product's id to delete product: ");
		try {
			int id = scanner.nextInt();
			if (productDAO.getProduct(id) == null) {
				pressEnterToContinue(scanner, "Id '" + id + "' does not exist!");
			} else {
				productDAO.deleteProduct(id);
				pressEnterToContinue(scanner, "Product '" + id + "' deleted successfully!");
			}
		} catch (InputMismatchException e) {
			pressEnterToContinue(scanner, "Invalid data input!");
		}
	}

	public void pressEnterToContinue(Scanner scanner, String str) {
		System.out.println(str);
		System.out.println("Press ENTER to continue...");
		scanner.nextLine();
		// When we continue reading with nextLine() after using nextInt() (or nextFloat(), etc...),
		// we receive the "\n" key, it automatically presses Enter key for us
		scanner.nextLine();
	}

}
