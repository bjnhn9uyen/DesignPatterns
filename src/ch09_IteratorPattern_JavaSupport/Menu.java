package ch09_IteratorPattern_JavaSupport;

import java.util.Iterator;

public interface Menu {

	public Iterator<MenuItem> createIterator();

	public String getMenuName();

}
