package hu.bme.mit.train.system;

import java.util.concurrent.Executor;

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

	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	Runnable task = () -> {
		controller.followSpeed();
	};
	public startExecution(){
		executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
	}

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}



}
