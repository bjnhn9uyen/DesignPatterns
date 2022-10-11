package ch02_ObserverPattern.Subject;

import ch02_ObserverPattern.Observers.Observer;

public interface Subject {

	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObservers();

}
