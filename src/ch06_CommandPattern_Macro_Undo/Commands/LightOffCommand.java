package ch06_CommandPattern_Macro_Undo.Commands;

import ch06_CommandPattern_Macro_Undo.VendorClasses.Light;

public class LightOffCommand implements Command {

	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}
