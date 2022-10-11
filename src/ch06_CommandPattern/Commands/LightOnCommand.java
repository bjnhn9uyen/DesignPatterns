package ch06_CommandPattern.Commands;

import ch06_CommandPattern.VendorClasses.Light;

public class LightOnCommand implements Command {

	// receiver of the request
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

}
