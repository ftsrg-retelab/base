package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainSensorImpl implements TrainSensor {

	Table<LocalDateTime, Integer, Integer> tachograph = HashBasedTable.create();

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private boolean danger = false;

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

	@Override
	public void dangerDetection(boolean hazard) {
		if (hazard == true) {
			danger = true;
			overrideSpeedLimit(0);
		}
	}

	@Override
	public void logTachograph() {
		tachograph.put(LocalDateTime.now(), user.getJoystickPosition(), controller.getReferenceSpeed());
	}

	public int getLogSize() {
		return tachograph.size();
	}

}
