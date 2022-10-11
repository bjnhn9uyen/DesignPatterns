package ch06_CommandPattern_Macro_Undo.VendorClasses;

public class Stereo {

	private String location;

	public Stereo(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " stereo is On!");
	}

	public void off() {
		System.out.println(location + " stereo is Off!");
	}

}
