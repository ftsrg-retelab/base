package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);

	public TrainController getController() {
		System.out.println("github.com/Bence56/base");
		return controller;
	}

	public TrainSensor getSensor() {
		System.out.println("github.com/Bence56/base");
		return sensor;
	}

	public TrainUser getUser() {
		System.out.println("github.com/Bence56/base");
		return user;
	}

}
