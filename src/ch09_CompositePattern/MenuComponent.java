package ch09_CompositePattern;

// MenuComponent represents the interface for both MenuItem and Menu (the leaf nodes and the composite nodes)
// We’ve used an abstract class here because we want to provide default implementations for these methods
public abstract class MenuComponent {

	// we’ve grouped together the “composite” methods, that is, methods to add, remove and get a MenuComponent
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	// here are the “operation” methods
	public String getName() {
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();
	}

}
