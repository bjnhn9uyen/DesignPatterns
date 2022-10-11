package ch02_ObserverPattern;

import ch02_ObserverPattern.Observers.CurrentConditionsDisplay;
import ch02_ObserverPattern.Observers.ForecastDisplay;
import ch02_ObserverPattern.Observers.HeatIndexDisplay;
import ch02_ObserverPattern.Observers.StatisticsDisplay;
import ch02_ObserverPattern.Subject.WeatherData;

public class WeatherStationTestDrive {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		 // create a display object and register it with the subject for observing data changes
		new CurrentConditionsDisplay(weatherData);
		new StatisticsDisplay(weatherData);
		new ForecastDisplay(weatherData);
		new HeatIndexDisplay(weatherData);

		// make changes of the weather data (the subject) by calling its setMeasurements method,
		// the setMeasurements method will call the notifyObservers method on the Subject,
		// the notifyObservers method will call update method on registered observer instances,
		// the update method then calls the display method on registered observer instances
		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println();
		weatherData.setMeasurements(82, 70, 29.2f);
		System.out.println();
		weatherData.setMeasurements(78, 90, 29.2f);
	}

}
