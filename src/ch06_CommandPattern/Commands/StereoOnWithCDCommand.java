package ch06_CommandPattern.Commands;

import ch06_CommandPattern.VendorClasses.Stereo;

public class StereoOnWithCDCommand implements Command {

	// receiver of the request
	private Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
	}

}
