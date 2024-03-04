package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.*;

public class TrainSensorImpl implements TrainSensor {

	private int time = 0;
	private TrainController controller;
	private TrainUser user;
	private Table<Integer, Integer, Integer> tachograph;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		this.tachograph = HashBasedTable.create();
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

	@Override
	public void TachographEntry() {
		tachograph.put(time++, user.getJoystickPosition(), controller.getReferenceSpeed());
	}

	public Boolean IsTachographEmpty() {
		return tachograph.isEmpty();
	}
}
