package ch09_CompositePattern;

public class Waitress {

//	 ArrayList<Menu> menus;

	// we just hand the Waitress the top level menu component, the one that contains all the other menus.
	MenuComponent allMenus;

	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}

	public void printMenu() {
//		Iterator<Menu> menuIterator = menus.iterator();
//		while (menuIterator.hasNext()) {
//			Menu menu = (Menu) menuIterator.next();
//			System.out.println(menu.getMenuName());
//			printMenu(menu.createIterator());
//		}

		// all things the Waitress has to do to print the entire menu hierarchy
		allMenus.print();
	}

	// other methods here

}
