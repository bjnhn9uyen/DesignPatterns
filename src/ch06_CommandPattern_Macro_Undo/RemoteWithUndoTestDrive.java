package ch06_CommandPattern_Macro_Undo;

import ch06_CommandPattern_Macro_Undo.Commands.CeilingFanHighCommand;
import ch06_CommandPattern_Macro_Undo.Commands.CeilingFanLowCommand;
import ch06_CommandPattern_Macro_Undo.Commands.CeilingFanMediumCommand;
import ch06_CommandPattern_Macro_Undo.Commands.CeilingFanOffCommand;
import ch06_CommandPattern_Macro_Undo.Commands.LightOffCommand;
import ch06_CommandPattern_Macro_Undo.Commands.LightOnCommand;
import ch06_CommandPattern_Macro_Undo.VendorClasses.CeilingFan;
import ch06_CommandPattern_Macro_Undo.VendorClasses.Light;

public class RemoteWithUndoTestDrive {

	public static void main(String[] args) {

		RemoteWithUndo remoteControl = new RemoteWithUndo();

		// testing light at the living room
		Light livingRoomLight = new Light("Living Room");

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

		// turn the light on, then off and then undo
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed(); // undo back on
		System.out.println();

		// then, turn the light off, back on and undo
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed(); // undo back off
		System.out.println();

		// testing ceiling fan at the living room
		CeilingFan ceilingFan = new CeilingFan("Living Room");

		CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		remoteControl.setCommand(0, ceilingFanLow, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff);

		remoteControl.onButtonWasPushed(0); // low
		remoteControl.offButtonWasPushed(0); // off
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed(); // undo back low

		remoteControl.onButtonWasPushed(1); // medium
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed(); // undo back low

		remoteControl.onButtonWasPushed(2); // high
		remoteControl.onButtonWasPushed(1); // medium
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed(); // undo back high

	}

}
