package ch09_IteratorPattern.ConcreteAggregates;

import java.util.ArrayList;

import ch09_IteratorPattern.Iterator;
import ch09_IteratorPattern.MenuItem;
import ch09_IteratorPattern.ConcreteIterators.PancakeHouseIterator;

public class PancakeHouseMenu {

	// using an ArrayList for expanding the menu easily
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

	// This method returns an ArrayList of menu items, we don’t want it to expose our internal implementation.
	// We encapsulate the iteration (encapsulate what varies) by create the createIterator() method instead
//	public ArrayList<MenuItem> getMenuItems() {
//		return menuItems;
//	}

	// create a PancakeHouseIterator from the menuItems array and return the Iterator interface to the client.
	// The client doesn’t need to know how the PancakeHouseIterator is implemented,
	// It just need to use the iterators to step through the items in the menu.
	public Iterator createIterator() {
		return new PancakeHouseIterator(menuItems);
	}

	// we have a bunch of code that depends on the implementation of our menu being an Array
	// other menu methods here

}
