package ch06_CommandPattern.Commands;

import ch06_CommandPattern.VendorClasses.GarageDoor;

public class GarageDoorDownCommand implements Command {

	// receiver of the request
	private GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.down();
	}

}
