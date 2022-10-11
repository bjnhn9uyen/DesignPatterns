package ch06_CommandPattern;

import ch06_CommandPattern.Commands.Command;
import ch06_CommandPattern.Commands.NoCommand;

public class RemoteControl {

	// the remote is going to handle seven On and Off commands, which we’ll hold in corresponding arrays
	Command[] onCommands;
	Command[] offCommands;

	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		// we didn’t want to check to see if a command was loaded every time we referenced a slot
		// so, we assign every slot a NoCommand object by default and
		// we know we’ll always have some command to call in each slot
		Command noCommand = new NoCommand(); // a command that does nothing
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	// the setCommand() method takes a slot position and an On and Off command to be stored in that slot
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	// when an On or Off button is pressed, the hardware takes care of calling the corresponding methods
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
	}

	// we’ve overwritten toString() to print out each slot and its corresponding command
	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n----- Remote Control -----\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + " "
									+ offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}

}
