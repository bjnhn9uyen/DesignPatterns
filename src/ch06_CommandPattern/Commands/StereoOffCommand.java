package ch06_CommandPattern.Commands;

import ch06_CommandPattern.VendorClasses.Stereo;

public class StereoOffCommand implements Command {

	// receiver of the request
	private Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}

}
