package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private boolean alarmState;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		int half = controller.getReferenceSpeed()/2;
		if(speedLimit<500 || speedLimit>0 || (speedLimit<half)) {
			user.setAlarmState(true);
		}
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

}
