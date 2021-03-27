package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

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
		if (speedLimit > 500 || speedLimit < 0){
			user.setAlarmState(true);
		}
		else if (controller.getReferenceSpeed()/2 > speedLimit){
			user.setAlarmState(true);
		}
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

}
