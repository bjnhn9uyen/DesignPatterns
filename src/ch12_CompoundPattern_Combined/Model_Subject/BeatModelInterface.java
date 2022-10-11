package ch12_CompoundPattern_Combined.Model_Subject;

import ch12_CompoundPattern_Combined.View_Observer.BPMObserver;
import ch12_CompoundPattern_Combined.View_Observer.BeatObserver;

public interface BeatModelInterface {

	// these are the methods the controller will use to direct the model based on user interaction
	void initialize();

	void on();

	void off();

	void setBPM(int bpm);

	// These methods allow the view and the controller to get state and to become observers.
	// We’ve split this into two kinds of observers: observers that want to be notified on every beat,
	// and observers that just want to be notified with the beats per minute change
	int getBPM();

	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void registerObserver(BPMObserver o);

	void removeObserver(BPMObserver o);
}
