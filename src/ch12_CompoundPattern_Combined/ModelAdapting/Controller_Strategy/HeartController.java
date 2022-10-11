package ch12_CompoundPattern_Combined.ModelAdapting.Controller_Strategy;

import ch12_CompoundPattern_Combined.Controller_Strategy.ControllerInterface;
import ch12_CompoundPattern_Combined.ModelAdapting.HeartAdapter;
import ch12_CompoundPattern_Combined.ModelAdapting.Model_Subject.HeartModelInterface;
import ch12_CompoundPattern_Combined.View_Observer.ConcreteObserver_Composite.DJView;

// The HeartController implements the ControllerInterface, just like the BeatController did
public class HeartController implements ControllerInterface {

	HeartModelInterface model;
	DJView view;

	// This time we pass a HeartModel, not a BeatModel,
	// and we need to wrap that model with an adapter before we hand it to the view
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(new HeartAdapter(model), this);
		view.setupWindow();
		view.disableStopMenuItem();
		view.disableStartMenuItem(); // the HeartController disables the menu items as they aren’t needed
	}

	// we can’t really control hearts like we can beat machines, so there's nothing to do with these methods
	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public void increaseBPM() {

	}

	@Override
	public void decreaseBPM() {

	}

	@Override
	public void setBPM(int bpm) {

	}

}
