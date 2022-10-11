package ch06_CommandPattern_Macro_Undo.Commands;

public interface Command {

	public void execute();

	public void undo();

}
