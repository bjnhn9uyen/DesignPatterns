package ch11_ProxyPattern_ProtectionProxy.InvocationHandlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ch11_ProxyPattern_ProtectionProxy.Subject.PersonBean;

public class NonOwnerInvocationHandler implements InvocationHandler {

	// pass the Real Subject in the constructor and keep a reference to it
	PersonBean person;

	public NonOwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	// The NonOwnerInvocationHandler works just like the OwnerInvocationHandler
	// except that it allows calls to setHotOrNotRating() and it disallows calls to any other set method
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
			} else if (method.getName().equals("setHotOrNotRating")) {
				return method.invoke(person, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
