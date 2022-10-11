package ch12_CompoundPattern_Combined;

import ch12_CompoundPattern_Combined.Controller_Strategy.BeatController;
import ch12_CompoundPattern_Combined.Model_Subject.BeatModelInterface;
import ch12_CompoundPattern_Combined.Model_Subject.ConcreteSubject.BeatModel;

public class DJTestDrive {

	public static void main(String[] args) {
		// First we create a model then create a controller and pass it the model.
		// Remember, the controller creates the view, so we don’t have to do that
		BeatModelInterface model = new BeatModel();
		new BeatController(model);
	}

}
