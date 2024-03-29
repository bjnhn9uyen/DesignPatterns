package ch06_CommandPattern_Macro_Undo.Commands;

import ch06_CommandPattern_Macro_Undo.VendorClasses.Hottub;

public class HottubOffCommand implements Command {

	private Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	@Override
	public void execute() {
		hottub.off();
	}

	@Override
	public void undo() {
		hottub.on();
	}

}
