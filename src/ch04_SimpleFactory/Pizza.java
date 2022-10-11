package ch04_SimpleFactory;

import java.util.ArrayList;

public abstract class Pizza {

	public String name;
	public String dough;
	public String sauce;
	public ArrayList<String> toppings = new ArrayList<>();

	public String getName() {
		return name;
	}

	void prepare() {
		System.out.println("Preparing " + name);
	}

	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	@Override
	public String toString() {
		// code to display pizza name and ingredients
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (int i = 0; i < toppings.size(); i++) {
			display.append((String) toppings.get(i) + "\n");
		}
		return display.toString();
	}

}
