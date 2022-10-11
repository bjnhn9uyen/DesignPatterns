package ch06_CommandPattern.Commands;

import ch06_CommandPattern.VendorClasses.GarageDoor;

public class GarageDoorUpCommand implements Command {

	// receiver of the request
	private GarageDoor garageDoor;

	public GarageDoorUpCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.up();
	}

}
