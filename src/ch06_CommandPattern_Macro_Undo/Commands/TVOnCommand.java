package ch06_CommandPattern_Macro_Undo.Commands;

import ch06_CommandPattern_Macro_Undo.VendorClasses.TV;

public class TVOnCommand implements Command {

	private TV tv;

	public TVOnCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.on();
	}

	@Override
	public void undo() {
		tv.off();
	}

}
