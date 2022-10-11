package ch02_ObserverPattern.Observers;

import ch02_ObserverPattern.Subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;

	// The constructor is passed the weatherData object (the Subject),
	// and we use it to register the display object as an observer
	public CurrentConditionsDisplay(Subject weatherData) {
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();

	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}

}
