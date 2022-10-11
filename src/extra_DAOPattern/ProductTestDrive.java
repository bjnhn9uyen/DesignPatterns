package extra_DAOPattern;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import extra_DAOPattern.TransferObject.ProductTransfer;

public class ProductTestDrive {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductTransfer productTransfer = new ProductTransfer();
		do {
			System.out.println("==========MENU==========");
			System.out.println("1. Add product");
			System.out.println("2. Show product list");
			System.out.println("3. Update product");
			System.out.println("4. Delete product");
			System.out.println("5. Exit program");
			System.out.print("Enter your choose: ");
			try {
				int choose = scanner.nextInt();
				if (choose > 0 && choose < 6) {
					try {
						switch (choose) {
						case 1:
							productTransfer.createProduct(scanner);
							break;
						case 2:
							productTransfer.readAllProducts(scanner);
							break;
						case 3:
							productTransfer.updateProduct(scanner);
							break;
						case 4:
							productTransfer.deleteProduct(scanner);
							break;
						case 5:
							scanner.close();
							System.exit(0);
						}
					} catch (SQLException e) {
						e.printStackTrace();
						break;
					}
				} else {
					productTransfer.pressEnterToContinue(scanner,
											"Invalid data input! Only integer number from 1 to 5 is allowed!");
				}
			} catch (InputMismatchException e) {
				productTransfer.pressEnterToContinue(scanner,
										"Invalid data input! Only integer number from 1 to 5 is allowed!");
			}
		} while (true);
	}

}
