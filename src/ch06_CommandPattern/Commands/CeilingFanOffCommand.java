package ch06_CommandPattern.Commands;

import ch06_CommandPattern.VendorClasses.CeilingFan;

public class CeilingFanOffCommand implements Command {

	// receiver of the request
	private CeilingFan ceilingFan;

	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void execute() {
		ceilingFan.off();
	}

}
