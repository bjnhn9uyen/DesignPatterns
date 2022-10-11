package ch06_CommandPattern_Macro_Undo.VendorClasses;

public class TV {

	private String location;

	public TV(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " TV is On!");
	}

	public void off() {
		System.out.println(location + " TV is Off!");
	}

}
