package ch11_ProxyPattern_ProtectionProxy;

import java.lang.reflect.Proxy;
import java.util.Hashtable;

import ch11_ProxyPattern_ProtectionProxy.InvocationHandlers.NonOwnerInvocationHandler;
import ch11_ProxyPattern_ProtectionProxy.InvocationHandlers.OwnerInvocationHandler;
import ch11_ProxyPattern_ProtectionProxy.RealSubject.PersonBeanImpl;
import ch11_ProxyPattern_ProtectionProxy.Subject.PersonBean;

public class MatchMakingTestDrive {

	Hashtable<String, PersonBean> database = new Hashtable<>();

	// the constructor initializes our database of people in the matchmaking service
	public MatchMakingTestDrive() {
		initializeDatabase();
	}

	public static void main(String[] args) {
		MatchMakingTestDrive test = new MatchMakingTestDrive();
		test.go();
	}

	void go() {
		initializeDatabase();
		// retrieve a person from the database and create an owner proxy
		PersonBean joe = getPersonFromDatabase("Joe Javabean");
		PersonBean ownerProxy = getOwnerProxy(joe);
		// call a getter and then a setter and then try to change the rating (this shouldn’t work!)
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

		// create a non-owner proxy and call a getter followed by a setter (this shouldn’t work!)
		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
		// try to set the rating (this should work!)
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
	}

	// This is where we dynamically create the proxy class and instantiate the proxy object.
	// This method takes a subject and returns a proxy for it.
	// Because the proxy has the same interface as the subject, we return a PersonBean as a proxy
	// We pass the subject into the constructor of the invocation handler,
	// this is how the handler gets access to the real subject (implementation of the subject)
	PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
								person.getClass().getInterfaces(),
								new OwnerInvocationHandler(person));
	}

	// this method is similar to getOwnerProxy method except it returns a proxy for the non-owner
	PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
								person.getClass().getInterfaces(),
								new NonOwnerInvocationHandler(person));
	}

	PersonBean getPersonFromDatabase(String name) {
		return (PersonBean) database.get(name);
	}

	void initializeDatabase() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		database.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		database.put(kelly.getName(), kelly);
	}

}
