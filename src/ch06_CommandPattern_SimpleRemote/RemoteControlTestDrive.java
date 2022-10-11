package ch06_CommandPattern_SimpleRemote;

import ch06_CommandPattern_SimpleRemote.Commands.CeilingFanOnCommand;
import ch06_CommandPattern_SimpleRemote.Commands.LightOnCommand;
import ch06_CommandPattern_SimpleRemote.Commands.TVOnCommand;
import ch06_CommandPattern_SimpleRemote.VendorClasses.CeilingFan;
import ch06_CommandPattern_SimpleRemote.VendorClasses.Light;
import ch06_CommandPattern_SimpleRemote.VendorClasses.TV;

public class RemoteControlTestDrive {

	public static void main(String[] args) {

		// the remote is invoker
		SimpleRemoteControl remote = new SimpleRemoteControl();

		// Light, TV, CeilingFan objects are the receivers
		Light light = new Light();
		TV tv = new TV();
		CeilingFan ceilingFan = new CeilingFan();

		// the invoker (remote) really isn’t worried about what’s on the command or who’s going to prepare it,
		// it just knows the command have an execute() method it can call to get the job done
		LightOnCommand lightOn = new LightOnCommand(light); // create a command and pass the receiver to it
		TVOnCommand tvOn = new TVOnCommand(tv);
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);

		// the invoker’s setCommand() method gets parameterized with different commands from different client
		remote.setCommand(lightOn); // pass the command to the invoker for calling setCommand() method

		// the invoker has the command that encapsulate the details of how to make things happen,
		// it didn’t care what command object it had, as long as the command implemented the Command interface
		// the receiver is the object that really knows how to prepare commands,
		// it never needs to directly communicate with the invoker,
		// in other words, the invoker and the receiver are totally decoupled
		remote.buttonWasPressed(); // the invoker calls execute() method

		remote.setCommand(tvOn);
		remote.buttonWasPressed();

		remote.setCommand(ceilingFanOn);
		remote.buttonWasPressed();

	}

}
