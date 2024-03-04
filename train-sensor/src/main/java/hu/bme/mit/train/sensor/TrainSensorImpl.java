package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import java.time.LocalDateTime;
import com.google.guava.*;
import java.util.Map;
import java.util.Set;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	Table<LocalDateTime, int, int> tachografDisc = null;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		this.tachografDisc = = HashBasedTable.create()
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
		tachografDisc.put(LocalDateTime.now(), controller.getJoystickPosition, controller.getReferenceSpeed);
	}

	@Override
	public Table<LocalDateTime, int, int> getTachografRecordings(){
		return tachografDisc;
	}

}
