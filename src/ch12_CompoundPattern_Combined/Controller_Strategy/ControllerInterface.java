package ch12_CompoundPattern_Combined.Controller_Strategy;

// this is the strategy interface that all concrete controllers implement
public interface ControllerInterface {

	// here are all the methods the view can call on the controller

	void start();

	void stop();

	void increaseBPM();

	void decreaseBPM();

	void setBPM(int bpm);
	
}
