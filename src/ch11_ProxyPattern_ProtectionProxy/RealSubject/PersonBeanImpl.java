package ch11_ProxyPattern_ProtectionProxy.RealSubject;

import ch11_ProxyPattern_ProtectionProxy.Subject.PersonBean;

public class PersonBeanImpl implements PersonBean {

	String name;
	String gender;
	String interests;
	int rating;
	int ratingCount = 0;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public String getInterests() {
		return interests;
	}

	@Override
	public int getHotOrNotRating() {
		if (ratingCount == 0)
			return 0;
		return (rating / ratingCount); // compute the average of the ratings
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void setInterests(String interests) {
		this.interests = interests;
	}

	@Override
	public void setHotOrNotRating(int rating) {
		// increment the total ratingCount and adds the rating to the running total
		this.rating += rating;
		ratingCount++;
	}

}
