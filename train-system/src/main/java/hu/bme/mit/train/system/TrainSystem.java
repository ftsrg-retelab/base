package hu.bme.mit.train.system;

import hu.bme.mit.train.clock.TrainClockTimer;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.tachograph.TrainTachograph;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainClockTimer timer = new TrainClockTimer(controller);
	private TrainUser user = new TrainUserImpl(controller, timer);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private TrainTachograph tachograph = TrainTachograph.getInstance();

	public TrainTachograph getTachograph() {return tachograph; }

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	public TrainClockTimer getTimer(){return timer;}

}
