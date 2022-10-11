package ch05_Singleton.ThreadSafe;

public class ChocolateBoiler {

	private boolean empty;
	private boolean boiled;

	// using synchronizing getInstance() method
//	private static ChocolateBoiler uniqueInstance;

	// using eager instantiation, from now on, we have only one instance (because it's static)
//	private static ChocolateBoiler uniqueInstance = new ChocolateBoiler();

	// using double-checked locking
	private volatile static ChocolateBoiler uniqueInstance;

	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	// synchronize getInstance() if calling the getInstance() method isn’t causing substantial overhead
//	public static synchronized ChocolateBoiler getInstance() {
//		if (uniqueInstance == null) {
//			uniqueInstance = new ChocolateBoiler();
//		}
//		return uniqueInstance;
//	}

	// using eager instantiation
//	public static ChocolateBoiler getInstance() {
//		return uniqueInstance;
//	}

	// using double-checked locking
	public static ChocolateBoiler getInstance() {
		// we first check to see if an instance is created, and if not, then we synchronize
		if (uniqueInstance == null) {
			// we only synchronize the first time through
			synchronized (ChocolateBoiler.class) {
				if (uniqueInstance == null) {
					System.out.println("Creating unique instance of Chocolate Boiler");
					uniqueInstance = new ChocolateBoiler();
					// when an instance is created, we no longer enter this synchronized block
				}
			}
		}
		System.out.println("Returning instance of Chocolate Boiler");
		return uniqueInstance;
	}

	public void fill() {
		// to fill the boiler it must be empty, and, once it’s full, we set the empty and boiled flags
		if (isEmpty()) {
			System.out.println("fill the boiler with a milk/chocolate mixture");
			empty = false;
			boiled = false;
		}
	}

	public void drain() {
		// to drain the boiler, it must be full (non empty) and also boiled.
		if (!isEmpty() && isBoiled()) {
			System.out.println("drain the boiled milk and chocolate");
			empty = true; // once it is drained we set empty back to true.
		}
	}

	public void boil() {
		// to boil the mixture, the boiler has to be full and not already boiled
		if (!isEmpty() && !isBoiled()) {
			System.out.println("bring the contents to a boil");
			boiled = true; // once it’s boiled we set the boiled flag to true
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

}
