package ch08_TemplateMethodPattern;

public abstract class CaffeineBeverageWithHook {

	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	abstract void brew();

	abstract void addCondiments();

	public final void boilWater() {
		System.out.println("Boiling water");
	}

	public final void pourInCup() {
		System.out.println("Pouring into cup");
	}

	// This method is a hook because the subclass can override this method, but doesn’t have to.
	// A hook is a method that is declared in the abstract class, given an empty or default implementation.
	// This gives subclasses the ability to “hook into” the algorithm at various points
	// the hook controls whether the CaffeineBeverage evaluates a certain part of the algorithm,
	// that is, whether it adds condiments to the beverage or not
	boolean customerWantsCondiments() {
		return true;
	}

}
