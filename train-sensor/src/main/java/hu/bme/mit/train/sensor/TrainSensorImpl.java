package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.Table;

import java.time.LocalDateTime;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<String, Integer, Integer> tachograph;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		tachograph = HashBasedTable.create();
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
	public void recordTachograph(int joystickPosition, int referenceSpeed) {
		String date = LocalDateTime.now().toString();
		tachograph.put(date, joystickPosition, referenceSpeed);
	}

	@Override
	public Table<String, Integer, Integer>  readTachograph() {
		return tachograph;
	}

}
