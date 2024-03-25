package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<Integer, Integer, Integer> tachograph  =  HashBasedTable.create();



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
		if((speedLimit < 0) || (speedLimit > 500)){
			user.setAlarmState(true);
		}
		else if(controller.getReferenceSpeed()*0.5 >= speedLimit){
			user.setAlarmState(true);
		}
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	public void addToTachograph(int currentTime, int joystickPosition, int speed){
		tachograph.put(currentTime, joystickPosition, speed);
	}

	public Table<Integer, Integer, Integer> getTacho(){
		return tachograph;
	}

	

}
