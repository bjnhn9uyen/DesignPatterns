package ch06_CommandPattern_SimpleRemote.Commands;

import ch06_CommandPattern_SimpleRemote.VendorClasses.Light;

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
