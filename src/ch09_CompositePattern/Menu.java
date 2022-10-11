package ch09_CompositePattern;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {

	// a Menu can have any number of children of type MenuComponent
	ArrayList<MenuComponent> menuComponents = new ArrayList<>();
	String name;
	String description;

	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int i) {
		return (MenuComponent) menuComponents.get(i);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");

		// The print() method prints not only the information of this Menu, but all of this Menu’s components
		// We use Iterator to iterate through all the Menu’s components, those could be other Menus,
		// or they could be MenuItems, we just call their implemented print() and the rest is up to them.
		// If during this iteration, we encounter another Menu object,
		// its print() method will start another iteration, and so on (recursive)
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			menuComponent.print();
		}
	}

}
