package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	public Table<String, Integer, Integer> tachograf;
	String ido;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		tachograf = HashBasedTable.create();
		
	}

	public void tick( String ido, int joystickPosition, int referenceSpeed)
	{
		tachograf.put(ido, joystickPosition, referenceSpeed);
	}

	public int getTachSize()
	{
		return tachograf.size();
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


