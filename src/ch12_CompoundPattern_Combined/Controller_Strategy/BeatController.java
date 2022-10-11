package ch12_CompoundPattern_Combined.Controller_Strategy;

import ch12_CompoundPattern_Combined.Model_Subject.BeatModelInterface;
import ch12_CompoundPattern_Combined.View_Observer.ConcreteObserver_Composite.DJView;

public class BeatController implements ControllerInterface {

	// the controller is the object that gets to hold on to the view and the model and glues it all together
	BeatModelInterface model;
	DJView view;

	// the controller is passed the model in the constructor and then creates the view
	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(model, this);
		view.setupWindow();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}

	@Override
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	@Override
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

	@Override
	public void increaseBPM() {
		int bpm = model.getBPM(); // get the current BPM from the model
		model.setBPM(bpm + 1); // add one, and then set a new BPM
	}

	@Override
	public void decreaseBPM() {
		int bpm = model.getBPM(); // get the current BPM from the model
		model.setBPM(bpm - 1); // subtract one, and then set a new BPM
	}

	@Override
	public void setBPM(int bpm) {
		// if the user interface is used to set an arbitrary BPM,
		// the controller instructs the model to set its BPM
		model.setBPM(bpm);
	}

}
