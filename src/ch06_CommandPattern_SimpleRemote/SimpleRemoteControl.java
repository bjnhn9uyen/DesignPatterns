package ch06_CommandPattern_SimpleRemote;

import ch06_CommandPattern_SimpleRemote.Commands.Command;

public class SimpleRemoteControl {

	private Command slot;

	public SimpleRemoteControl() {
	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}

}
