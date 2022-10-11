package ch09_IteratorPattern;

import ch09_IteratorPattern.ConcreteAggregates.DinerMenu;
import ch09_IteratorPattern.ConcreteAggregates.PancakeHouseMenu;

public class Waitress {

	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;

	// the Waitress takes the two menus
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	/** without using Iterator pattern */
	// the method getMenuItems() looks the same in both, but the calls are returning different types
//	 ArrayList<MenuItem> breakfastItems = new PancakeHouseMenu().getMenuItems();
//	 MenuItem[] lunchItems = new DinerMenu().getMenuItems();

	// To print out the PancakeHouseMenu’s items, we’ll loop through the ArrayList,
	// and to print out the Diner items we’ll loop through the Array, we are using different way of iteration.
	// We don’t want to expose the implementation of iterations, we encapsulate it (encapsulate what varies) 
	// by putting it into the separate implementation of Iterator and calling the createIterator() method
	// to return the Iterator interface, the Waitress doesn’t need to know how the iteration implemented,
//	public void printMenu() {
//		for (MenuItem menuItem : breakfastItems) {
//			System.out.print(menuItem.getName() + " ");
//			System.out.println(menuItem.getPrice() + " ");
//			System.out.println(menuItem.getDescription());
//		}
//
//		for (int i = 0; i < lunchItems.length; i++) {
//			MenuItem menuItem = lunchItems[i];
//			System.out.print(menuItem.getName() + " ");
//			System.out.println(menuItem.getPrice() + " ");
//			System.out.println(menuItem.getDescription());
//		}
//	}
	
	// create two iterators, one for each menu, and then call the printMenu method with each iterator
	public void doPrintMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("MENU\n----\nBREAKFAST (use pancake menu for breakfast)");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH (use diner menu for lunch)");
		printMenu(dinerIterator);
	}

	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	/** for Vegetarian */
	
	public void doPrintVegetarianMenu() {
		System.out.println("\nBREAKFAST (Vegetarian)");
		printVegetarianMenu(pancakeHouseMenu.createIterator());
		System.out.println("\nLUNCH (Vegetarian)");
		printVegetarianMenu(dinerMenu.createIterator());
	}
	
	private void printVegetarianMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName() + ", ");
				System.out.print(menuItem.getPrice() + " -- ");
				System.out.println(menuItem.getDescription());
			}
		}
	}

	public boolean doCheckItemVegetarian(String name) {
		Iterator breakfastIterator = pancakeHouseMenu.createIterator();
		if (isItemVegetarian(name, breakfastIterator)) {
			return true;
		}
		Iterator dinnerIterator = dinerMenu.createIterator();
		if (isItemVegetarian(name, dinnerIterator)) {
			return true;
		}
		return false;
	}

	private boolean isItemVegetarian(String name, Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.getName().equals(name)) {
				if (menuItem.isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}

}
