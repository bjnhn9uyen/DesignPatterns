package ch11_ProxyPattern_ProtectionProxy.Subject;

public interface PersonBean {

	String getName();

	String getGender();

	String getInterests();

	int getHotOrNotRating();

	void setName(String name);

	void setGender(String gender);

	void setInterests(String interests);

	void setHotOrNotRating(int rating);

}

// We want to make sure that a customer can set his own information while preventing others from altering it
// In the opposite, we want the other customers to be able to set only the rating of the others.
// This is a perfect example of Protection Proxy, it controls access to an object based on access rights.
// All we need to do is supply two handler classes that know what to do when a method is invoked on the proxy,
// one for a customer to access his/her own PersonBean object (OwnerInvocationHandler)
// and one for him/her to access another customer’s PersonBean object (NonOwnerInvocationHandler)
// We’re going to use the Java API’s dynamic proxy (in the java.lang.reflect package).
// Java will create two proxies class for us at runtime, so we refer to this technology as a dynamic proxy
