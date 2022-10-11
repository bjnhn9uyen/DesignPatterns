package ch06_CommandPattern;

import ch06_CommandPattern.Commands.CeilingFanOffCommand;
import ch06_CommandPattern.Commands.CeilingFanOnCommand;
import ch06_CommandPattern.Commands.GarageDoorDownCommand;
import ch06_CommandPattern.Commands.GarageDoorUpCommand;
import ch06_CommandPattern.Commands.LightOffCommand;
import ch06_CommandPattern.Commands.LightOnCommand;
import ch06_CommandPattern.Commands.StereoOffCommand;
import ch06_CommandPattern.Commands.StereoOnWithCDCommand;
import ch06_CommandPattern.VendorClasses.CeilingFan;
import ch06_CommandPattern.VendorClasses.GarageDoor;
import ch06_CommandPattern.VendorClasses.Light;
import ch06_CommandPattern.VendorClasses.Stereo;

public class RemoteControlTestDrive {

	public static void main(String[] args) {

		RemoteControl remoteControl = new RemoteControl();

		// create all the devices in their proper locations
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor();
		Stereo stereo = new Stereo("Living Room");

		// create all the Light Command objects
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

		// create the On and Off for the ceiling fan
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		// create the Up and Down commands for the Garage
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

		// create the stereo On and Off commands
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);

		// now that we’ve got all our commands, we can load them into the remote slots
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
		remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
		remoteControl.setCommand(4, stereoOnWithCD, stereoOff);

		// print each remote slot and the command that it is assigned to
		System.out.println(remoteControl);

		// we are ready to roll! Now, we step through each slot and push its On and Off button.
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		remoteControl.onButtonWasPushed(4);
		remoteControl.offButtonWasPushed(4);

	}

}
