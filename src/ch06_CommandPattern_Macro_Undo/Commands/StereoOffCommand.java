package ch06_CommandPattern_Macro_Undo.Commands;

import ch06_CommandPattern_Macro_Undo.VendorClasses.Stereo;

public class StereoOffCommand implements Command {

	private Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}

	@Override
	public void undo() {
		stereo.on();
	}

}
