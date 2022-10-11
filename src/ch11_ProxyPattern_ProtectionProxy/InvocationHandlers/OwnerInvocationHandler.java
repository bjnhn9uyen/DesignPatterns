package ch11_ProxyPattern_ProtectionProxy.InvocationHandlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ch11_ProxyPattern_ProtectionProxy.Subject.PersonBean;

public class OwnerInvocationHandler implements InvocationHandler {

	// pass the Real Subject in the constructor and keep a reference to it
	PersonBean person;

	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	// when a method call is made on the proxy, the proxy forwards that call to your InvocationHandler,
	// then the invoke method is what gets called on the handler
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				// if the method is a getter, we go ahead and invoke it on the real subject.
				return method.invoke(person, args);
			} else if (method.getName().equals("setHotOrNotRating")) {
				// if the method is the setHotOrNotRating method we disallow it by throwing an Exception
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				// if any other set method and we go ahead and invoke it on the real subject
				return method.invoke(person, args);
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
