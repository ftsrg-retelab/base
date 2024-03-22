package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import java.util.*;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	public Table<String, Integer, Integer> tachnographTable = HashBasedTable.create();
	

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
		if (speedLimit < 0 || speedLimit > 500 || (speedLimit < this.speedLimit * 0.5)) {
			user.setAlarmState(true); 
		} else {
			user.setAlarmState(false); 
		}
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}


	public void addRecord(String date, Integer joystickPosition, Integer referenceSpeed){
		tachnographTable.put(date, joystickPosition, referenceSpeed);
	}

}