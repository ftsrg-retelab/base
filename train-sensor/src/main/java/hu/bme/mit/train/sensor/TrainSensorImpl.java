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
		this.user.setAlarmState(AbsoluteMargin(speedLimit));

		if(user.getAlarmState())
			return;

		this.speedLimit = speedLimit;

		this.user.setAlarmState(RelativeMargin());
		controller.setSpeedLimit(speedLimit);

	}

	private boolean AbsoluteMargin(int speedLimit){
		return speedLimit < 0 || speedLimit > 500;
	}

	private boolean RelativeMargin() {
		return this.speedLimit < this.controller.getReferenceSpeed() * 0.5;
	}
}
