package ch09_IteratorPattern.ConcreteAggregates;

import ch09_IteratorPattern.Iterator;
import ch09_IteratorPattern.MenuItem;
import ch09_IteratorPattern.ConcreteIterators.DinerMenuIterator;

public class DinerMenu {

	// using an Array so we can control the max size of the menu,
	// and retrieve menu items out without having to cast our objects
	MenuItem[] menuItems;
	int numberOfItems = 0;
	static final int MAX_ITEMS = 6;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
		addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog", "A hot dog, with sauerkraut, relish, onions, topped with cheese", false, 3.05);
		addItem("Steamed Veggies and Brown Rice", "Medly of steamed vegetables over brown rice", true, 3.99);
		addItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89);
	}

	// we want to keep our menu under a certain size (so we don’t have to remember too many recipes)
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, menu is full! Can’t add item to menu");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}

	// This method returns an array of menu items, we don’t want it to expose our internal implementation.
	// We encapsulate the iteration (encapsulate what varies) by creating the createIterator() method instead
//	public MenuItem[] getMenuItems() {
//		return menuItems;
//	}

	// create a DinerMenuIterator from the menuItems array and return the Iterator interface to the client.
	// The client doesn’t need to know how the DinerMenuIterator is implemented,
	// It just need to use the iterators to step through the items in the menu.
	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}

	// we have a bunch of code that depends on the implementation of our menu being an Array
	// other menu methods here

}
