package ch12_CompoundPattern_Combined.ModelAdapting;

import ch12_CompoundPattern_Combined.ModelAdapting.Model_Subject.HeartModelInterface;
import ch12_CompoundPattern_Combined.Model_Subject.BeatModelInterface;
import ch12_CompoundPattern_Combined.View_Observer.BPMObserver;
import ch12_CompoundPattern_Combined.View_Observer.BeatObserver;

// What the DJ View does displaying a beat rate and a pulse. How about a heart beat?
// It certainly would be nice to reuse our current DJView with the HeartModel,
// but we need a controller that works with this model.
// Also, the interface of the HeatModel doesn’t match what the view expects,
// so, we’re going to need to adapt the HeartModel to a BeatModel.
public class HeartAdapter implements BeatModelInterface {

	HeartModelInterface heart;

	public HeartAdapter(HeartModelInterface heart) {
		this.heart = heart;
	}

	// We don’t know what these four methods below would do to a heart, so we’ll just leave them as “no ops”
	@Override
	public void initialize() {

	}

	@Override
	public void on() {

	}

	@Override
	public void off() {

	}

	@Override
	public void setBPM(int bpm) {

	}

	// when getBPM() is called, we’ll just translate it to a getHeartRate() call on the heart model
	@Override
	public int getBPM() {
		return heart.getHeartRate();
	}

	// here are our four observer methods, and we just delegate them to the wrapped heart model
	@Override
	public void registerObserver(BeatObserver o) {
		heart.registerObserver(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		heart.removeObserver(o);
	}

	@Override
	public void registerObserver(BPMObserver o) {
		heart.registerObserver(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		heart.removeObserver(o);
	}

}
