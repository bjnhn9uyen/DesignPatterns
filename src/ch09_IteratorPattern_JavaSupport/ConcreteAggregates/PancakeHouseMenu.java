package ch09_IteratorPattern_JavaSupport.ConcreteAggregates;

import java.util.ArrayList;
import java.util.Iterator;

import ch09_IteratorPattern_JavaSupport.Menu;
import ch09_IteratorPattern_JavaSupport.MenuItem;

public class PancakeHouseMenu implements Menu {

	ArrayList<MenuItem> menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList<>();
		addItem("K&B’s Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
		addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
		addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
		addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

	@Override
	public Iterator<MenuItem> createIterator() {
		// return new PancakeHouseIterator(menuItems);
		return menuItems.iterator();
	}

	@Override
	public String getMenuName() {
		return "\nBREAKFAST (use pancake menu for breakfast)";
	}

	// we have a bunch of code that depends on the implementation of our menu being an Array
	// other menu methods here

}
