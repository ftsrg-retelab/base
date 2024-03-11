package hu.bme.mit.train.sensor;

import java.time.LocalTime;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	private Table<LocalTime, Integer, Integer> tachograph = HashBasedTable.create();

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
    public void recordData() {
        // Record data to tachograph
        LocalTime currentTime = LocalTime.now();
        int joystickPosition = user.getJoystickPosition();
        int referenceSpeed = controller.getReferenceSpeed();
        tachograph.put(currentTime, joystickPosition, referenceSpeed);
    }

    @Override
    public Table<LocalTime, Integer, Integer> getTachograph() {
        return tachograph;
    }

}
