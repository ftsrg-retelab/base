package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private final TrainUser user;
	private TrainController controller;

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

		if((speedLimit < 0) || (speedLimit > 500)) {
			user.setAlarmState(true);
		}

		if((0.5*(controller.getReferenceSpeed()))>speedLimit){
			user.setAlarmState(true);
		}

		else{
			this.speedLimit = speedLimit;
			controller.setSpeedLimit(speedLimit);
		}
	}

}
