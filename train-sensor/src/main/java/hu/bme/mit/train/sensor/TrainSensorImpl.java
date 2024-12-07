package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public Table<Long, Integer, Integer> table;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		table = HashBasedTable.create();
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
	public long getCurrentTime() {
		return System.currentTimeMillis();
	}

	@Override
	public int getReferenceSpeed() {
		return controller.getReferenceSpeed();
	}

	@Override
	public int getJoystickPosition() {
		return user.getJoystickPosition();
	}

	@Override
	public void updateTable() {
		long time = getCurrentTime();
		int refSpeed = getReferenceSpeed();
		int joystickPos = getJoystickPosition();

		table.put(time, refSpeed, joystickPos);
	}

	@Override
	public int getTableSize() {
		return table.size();
	}
}
