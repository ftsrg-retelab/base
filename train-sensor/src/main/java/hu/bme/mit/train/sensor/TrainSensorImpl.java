package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private int speedLimit;
	private TrainUser user;

	
	public TrainSensorImpl(TrainController controller) {
		this.controller = controller;
	}

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user; 
	}

	
	

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit){
		this.speedLimit = speedLimit;
	} 

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		if(this.speedLimit<0 || this.speedLimit>500 || this.speedLimit<((controller.getReferenceSpeed())*0.5 ))
			user.setAlarmState(true);
		controller.setSpeedLimit(speedLimit);
	}

}
