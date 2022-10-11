package ch09_IteratorPattern_JavaSupport;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {

	ArrayList<Menu> menus;

	public Waitress(ArrayList<Menu> menus) {
		this.menus = menus;
	}

	public void doPrintMenu() {
		System.out.println("MENU\n---------------");
		Iterator<Menu> menuIterator = menus.iterator();
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			System.out.println(menu.getMenuName());
			printMenu(menu.createIterator());
		}
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	/** for Vegetarian */

	public void doPrintVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n---------------");
		Iterator<Menu> menuIterator = menus.iterator();
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			System.out.println(menu.getMenuName() + " for Vegetarian");
			printVegetarianMenu(menu.createIterator());
		}
	}

	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
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
		Iterator<Menu> menuIterator = menus.iterator();
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			Iterator<MenuItem> iterator = menu.createIterator();
			if (isItemVegetarian(name, iterator)) {
				return true;
			}
		}
		return false;
	}

	private boolean isItemVegetarian(String name, Iterator<MenuItem> iterator) {
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
