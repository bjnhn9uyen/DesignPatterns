package ch09_IteratorPattern.ConcreteIterators;

import ch09_IteratorPattern.Iterator;
import ch09_IteratorPattern.MenuItem;

// implement this Iterator and hook it into the DinerMenu
public class DinerMenuIterator implements Iterator {

	MenuItem[] items;

	// position maintains the current position of the iteration over the array
	int position = 0;

	// the constructor takes the array of menu items we are going to iterate over
	public DinerMenuIterator(MenuItem[] items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

}
