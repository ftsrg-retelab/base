package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.Table;
import java.util.Date;
import com.google.common.collect.HashBasedTable;
import java.lang.Integer;


public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<Date, Integer, Integer> tachograf  = HashBasedTable.create();


	public void addToTapograf(){
		tachograf.put(new Date(), user.getJoystickPosition(), controller.getReferenceSpeed());
	}

	public int getTapografSize(){
		return tachograf.size();
	}

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
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

}
