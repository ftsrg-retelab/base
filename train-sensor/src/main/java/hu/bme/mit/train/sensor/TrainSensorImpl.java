package hu.bme.mit.train.sensor;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<Integer,Integer,Integer> tachoTable;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		tachoTable = TreeBasedTable.create();
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
	public void recordTacho(int time, int joystickPosition, int referenceSpeed)
	{
		tachoTable.put(time, joystickPosition, referenceSpeed);
	}

	@Override
	public int getTachoSize()
	{
		return tachoTable.size();
	}

}
