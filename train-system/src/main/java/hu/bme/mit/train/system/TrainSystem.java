package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

	private static final TrainController controller = new TrainControllerImpl();
	private static final TrainUser user = new TrainUserImpl(controller);
	private static final TrainSensor sensor = new TrainSensorImpl(controller, user);

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}


	public static void main(String[] args) {
		sensor.overrideSpeedLimit(130);
		user.overrideJoystickPosition(5);

		while(!user.getAlarmFlag()){
			controller.followSpeed();
			System.out.print("sihuhuuuu ");
		}
	}

}
