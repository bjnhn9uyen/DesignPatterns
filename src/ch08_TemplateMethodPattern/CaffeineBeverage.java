package ch08_TemplateMethodPattern;

public abstract class CaffeineBeverage {

	// The prepareRecipe() is our template method because it serves as a template for an algorithm.
	// In the template, each step of the algorithm is represented by a method.
	// Some methods are handled by this class and some are handled by the subclass.
	// The methods that need to be supplied by a subclass are declared abstract.
	// The method is declared ‘final’ because we don’t want our subclasses to be able to override this method,
	// and change the recipe (the sequence of steps in the algorithm)
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	abstract void brew();

	abstract void addCondiments();

	// mark the method ‘final’ so that subclasses can’t override it,
	// because it may be used in the template method directly, or used by subclasses
	public final void boilWater() {
		System.out.println("Boiling water");
	}

	public final void pourInCup() {
		System.out.println("Pouring into cup");
	}

}
