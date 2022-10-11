package ch06_CommandPattern.VendorClasses;

public class CeilingFan {

	private String location;

	public CeilingFan(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " ceiling fan is On!");
	}

	public void off() {
		System.out.println(location + " ceiling fan is Off!");
	}

}
