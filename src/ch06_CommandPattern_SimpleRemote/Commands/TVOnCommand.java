package ch06_CommandPattern_SimpleRemote.Commands;

import ch06_CommandPattern_SimpleRemote.VendorClasses.TV;

public class TVOnCommand implements Command {

	// receiver of the request
	private TV tv;

	public TVOnCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.on();
	}

}
