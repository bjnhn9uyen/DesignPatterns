package ch07_AdapterPattern;

import ch07_AdapterPattern.ExistingSystem.Duck;
import ch07_AdapterPattern.VendorClasses.Turkey;

// implement the interface of the type you’re adapting to, this is the interface your client expects to see
public class TurkeyAdapter implements Duck {

	Turkey turkey;

	// get a reference to the object that we are adapting
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	// the quack() translation between classes is easy, just call the gobble() method
	@Override
	public void quack() {
		turkey.gobble();
	}

	// Turkeys fly in short spurts, they can’t do long-distance flying like ducks,
	// so we need to call the Turkey’s fly() method five times to make up for it
	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}

}
