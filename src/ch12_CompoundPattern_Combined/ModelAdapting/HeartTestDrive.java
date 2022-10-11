package ch12_CompoundPattern_Combined.ModelAdapting;

import ch12_CompoundPattern_Combined.ModelAdapting.Controller_Strategy.HeartController;
import ch12_CompoundPattern_Combined.ModelAdapting.Model_Subject.ConcreteSubject.HeartModel;

public class HeartTestDrive {

	public static void main(String[] args) {
		HeartModel heartModel = new HeartModel();
		new HeartController(heartModel);
	}

}
