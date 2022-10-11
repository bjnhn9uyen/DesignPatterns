package ch05_Singleton;

public class Singleton {

	// we have a static variable to hold our one instance of the class Singleton
	private static Singleton uniqueInstance;

	// this class can’t be instantiated because it has a private constructor
	// the code in this class is the only code that could call this private constructor,
	// so we can use the static method getInstance() to call it
	private Singleton() {
		super();
	}

	public static Singleton getInstance() {
		// if uniqueInstance is null, then we haven’t created the instance yet...
		if (uniqueInstance == null) {
			// if we never need the instance, it never gets created; this is lazy instantiation.
			uniqueInstance = new Singleton();
		}
		// if uniqueInstance wasn’t null, then it was previously created
		return uniqueInstance;
	}

}

/** this is not thread safe! */