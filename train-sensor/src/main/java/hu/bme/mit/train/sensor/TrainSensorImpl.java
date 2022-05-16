package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 10;

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
		user.setAlarmState(false);
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
		if (speedLimit < 0 || speedLimit > 500 || this.speedLimit * 0.5 >  speedLimit ) user.setAlarmState(true);
	}
	public TrainUser getUser(){
		return user;
	}	

}
