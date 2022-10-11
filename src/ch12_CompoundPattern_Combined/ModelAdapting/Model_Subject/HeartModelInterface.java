package ch12_CompoundPattern_Combined.ModelAdapting.Model_Subject;

import ch12_CompoundPattern_Combined.View_Observer.BPMObserver;
import ch12_CompoundPattern_Combined.View_Observer.BeatObserver;

public interface HeartModelInterface {

	int getHeartRate();

	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void registerObserver(BPMObserver o);

	void removeObserver(BPMObserver o);

}
