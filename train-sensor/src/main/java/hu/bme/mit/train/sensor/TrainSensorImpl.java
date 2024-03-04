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

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	Table<LocalDateTime, Integer, Integer> tachografDisc = null;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		this.tachografDisc = HashBasedTable.create();
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
		tachograf();
	}

	private void tachograf() {
		this.tachografDisc.put(LocalDateTime.now(), controller.getJoystickPosition(), controller.getReferenceSpeed());
	}

	@Override
	public Table<LocalDateTime, Integer, Integer> getTachografRecordings(){
		return tachografDisc;
	}

}
