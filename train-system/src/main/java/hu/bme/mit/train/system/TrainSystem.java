package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.*;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.tachograph.TrainTachographImpl;
import hu.bme.mit.train.runner.TrainRunnerImpl;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private TrainTachograph tachograph = new TrainTachographImpl(controller, user);

	private TrainRunner runner = new TrainRunnerImpl(controller);

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	public TrainTachograph getTachograph() { return tachograph; }

	public TrainRunner getRunner(){ return runner;	}

}
