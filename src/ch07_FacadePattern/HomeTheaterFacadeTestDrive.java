package ch07_FacadePattern;

import ch07_FacadePattern.Subsystems.Amplifier;
import ch07_FacadePattern.Subsystems.PopcornPopper;
import ch07_FacadePattern.Subsystems.Projector;
import ch07_FacadePattern.Subsystems.Screen;
import ch07_FacadePattern.Subsystems.StreamingPlayer;
import ch07_FacadePattern.Subsystems.TheaterLights;
import ch07_FacadePattern.Subsystems.Tuner;

public class HomeTheaterFacadeTestDrive {

	public static void main(String[] args) {

		// normally the client is given a facade to instantiate components,
		// it doesn’t have to construct one itself
		Amplifier amp = new Amplifier("Amplifier");
		Tuner tuner = new Tuner("AM/FM Tuner", amp);
		StreamingPlayer player = new StreamingPlayer("Streaming Player", amp);
		Projector projector = new Projector("Projector", player);
		TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
		Screen screen = new Screen("Theater Screen");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");

		// instantiate the Facade with all the components in the subsystem
		HomeTheaterFacade homeTheater =
								new HomeTheaterFacade(amp, tuner, player, projector, screen, lights, popper);

		// use the simplified interface to first start the movie up, and then shut it down
		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();

	}

}
