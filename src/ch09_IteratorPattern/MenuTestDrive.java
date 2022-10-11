package ch09_IteratorPattern;

import ch09_IteratorPattern.ConcreteAggregates.DinerMenu;
import ch09_IteratorPattern.ConcreteAggregates.PancakeHouseMenu;

public class MenuTestDrive {

	public static void main(String[] args) {

		// create menus
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		// create a Waitress and pass her the menus to print them
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		waitress.doPrintMenu();
		waitress.doPrintVegetarianMenu();
		
		System.out.println("\nCustomer asks, is the Hotdog vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.doCheckItemVegetarian("Hotdog")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		System.out.println("\nCustomer asks, are the Waffles vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.doCheckItemVegetarian("Waffles")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
