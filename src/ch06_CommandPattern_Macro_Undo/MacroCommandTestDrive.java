package ch06_CommandPattern_Macro_Undo;

import ch06_CommandPattern_Macro_Undo.Commands.Command;
import ch06_CommandPattern_Macro_Undo.Commands.HottubOffCommand;
import ch06_CommandPattern_Macro_Undo.Commands.HottubOnCommand;
import ch06_CommandPattern_Macro_Undo.Commands.LightOffCommand;
import ch06_CommandPattern_Macro_Undo.Commands.LightOnCommand;
import ch06_CommandPattern_Macro_Undo.Commands.MacroCommand;
import ch06_CommandPattern_Macro_Undo.Commands.StereoOffCommand;
import ch06_CommandPattern_Macro_Undo.Commands.StereoOnCommand;
import ch06_CommandPattern_Macro_Undo.Commands.TVOffCommand;
import ch06_CommandPattern_Macro_Undo.Commands.TVOnCommand;
import ch06_CommandPattern_Macro_Undo.VendorClasses.Hottub;
import ch06_CommandPattern_Macro_Undo.VendorClasses.Light;
import ch06_CommandPattern_Macro_Undo.VendorClasses.Stereo;
import ch06_CommandPattern_Macro_Undo.VendorClasses.TV;

public class MacroCommandTestDrive {

	public static void main(String[] args) {

		RemoteWithUndo remoteControl = new RemoteWithUndo();

		// create all the devices, a light, TV, stereo, and hot tub
		Light light = new Light("Living Room");
		TV tv = new TV("Living Room");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();

		// create all the On commands to control them
		LightOnCommand lightOn = new LightOnCommand(light);
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		TVOnCommand tvOn = new TVOnCommand(tv);
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);

		// create all the Off commands
		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		TVOffCommand tvOff = new TVOffCommand(tv);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);

		// create an array for On and an array for Off commands and create two macros to hold them
		Command[] partyOn = { lightOn, stereoOn, tvOn, hottubOn };
		Command[] partyOff = { lightOff, stereoOff, tvOff, hottubOff };
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);

		// we assign MacroCommand to a button like we always do
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
		System.out.println("--- Pushing Macro Undo---");
		remoteControl.undoButtonWasPushed();

	}

}
