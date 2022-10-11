package ch06_CommandPattern_Macro_Undo;

import ch06_CommandPattern_Macro_Undo.Commands.Command;
import ch06_CommandPattern_Macro_Undo.Commands.NoCommand;

public class RemoteWithUndo {

	private Command[] onCommands;
	private Command[] offCommands;

	// we’ll add a new instance variable to track the last command invoked.
	// Then, whenever the undo button is pressed, we retrieve that command and invoke its undo() method
	private Command undoCommand;

	public RemoteWithUndo() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}

		// undo starts off with a NoCommand, so pressing undo before any other button won’t do anything at all
		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();

		// When a button is pressed, we take the command and first execute it,
		// then we save a reference to it in the undoCommand instance variable
		// We do this for both “on” commands and “off” commands
		undoCommand = onCommands[slot];
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}

	// reverse the operation of the last command executed
	public void undoButtonWasPushed() {
		undoCommand.undo();
	}

	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + " "
									+ offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}

}
