package hu.bme.mit.train.sensor;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<String, Integer, Integer> tachograph = HashBasedTable.create(); //DATETIME, REFERENCE SPEED, JOYSTICK POSITION 

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
	public void saveTachograph(String time, int referenceSpeed, int joystickPosition) {
		tachograph.put(time, referenceSpeed, joystickPosition);
	}

	@Override
	public Table<String, Integer, Integer> getTachograph() {
		return tachograph;
	}

}
