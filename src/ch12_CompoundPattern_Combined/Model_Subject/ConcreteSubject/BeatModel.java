package ch12_CompoundPattern_Combined.Model_Subject.ConcreteSubject;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;

import ch12_CompoundPattern_Combined.DJTestDrive;
import ch12_CompoundPattern_Combined.Model_Subject.BeatModelInterface;
import ch12_CompoundPattern_Combined.View_Observer.BPMObserver;
import ch12_CompoundPattern_Combined.View_Observer.BeatObserver;

// MetaEventListener is needed for the MIDI code
public class BeatModel implements BeatModelInterface, Runnable {

	// these ArrayLists hold the two kinds of observers (Beat and BPM observers)
	ArrayList<BeatObserver> beatObservers = new ArrayList<>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
	int bpm = 90; // the bpm instance variable holds the frequency of beats (default is 90 BPM)
	Thread thread;
	boolean stop = false;
	Clip clip;

	@Override
	public void initialize() {
		File resource = new File("src/" + DJTestDrive.class.getPackageName() + "/clap.wav");
		System.out.println(resource);
		try {
			clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(AudioSystem.getAudioInputStream(resource));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void on() {
		setBPM(90);
		notifyBPMObservers();
		thread = new Thread(this);
		stop = false;
		thread.start();
	}

	@Override
	public void off() {
		stopBeat();
		stop = true;
	}

	// the setBPM method is the way the controller manipulates the beat
	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		notifyBPMObservers();
	}

	@Override
	public int getBPM() {
		return bpm; // returns the current beats per minute
	}

	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	@Override
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	public void notifyBeatObservers() {
		for (int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver) beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void notifyBPMObservers() {
		for (int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver) bpmObservers.get(i);
			observer.updateBPM();
		}
	}

	@Override
	public void run() {
		while (!stop) {
			playBeat();
			notifyBeatObservers();
			try {
				Thread.sleep(60000 / getBPM());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void playBeat() {
		clip.setFramePosition(0);
		clip.start();
	}

	public void stopBeat() {
		clip.setFramePosition(0);
		clip.stop();
	}

}
