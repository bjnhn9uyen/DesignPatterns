package ch06_CommandPattern_Macro_Undo.VendorClasses;

public class CeilingFan {

	private String location;
	private int speed;
	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	public static final int OFF = 0;

	public CeilingFan(String location) {
		this.location = location;
		speed = OFF;
	}

	public int getSpeed() {
		return speed;
	}

	public void high() {
		speed = HIGH;
		// code to set fan to high
		System.out.println(location + " ceiling fan is on high");
	}

	public void medium() {
		speed = MEDIUM;
		// code to set fan to medium
		System.out.println(location + " ceiling fan is on medium");
	}

	public void low() {
		speed = LOW;
		// code to set fan to low
		System.out.println(location + " ceiling fan is on low");
	}

	public void off() {
		speed = OFF;
		// code to turn fan off
		System.out.println(location + " ceiling fan is off");
	}

}
