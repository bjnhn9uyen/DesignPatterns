package ch06_CommandPattern_SimpleRemote.Commands;

import ch06_CommandPattern_SimpleRemote.VendorClasses.CeilingFan;

public class CeilingFanOnCommand implements Command {

	// receiver of the request
	private CeilingFan ceilingFan;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void execute() {
		ceilingFan.on();
	}

}
