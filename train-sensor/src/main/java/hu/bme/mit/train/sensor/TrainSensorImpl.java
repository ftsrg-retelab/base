package hu.bme.mit.train.sensor;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import java.util.Date;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<Date,Integer,Integer> tachograph;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		this.tachograph = TreeBasedTable.create();
	}

	public Table<Date,Integer,Integer> getTachograph() { return this.tachograph; }

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
	public void saveValues(){
		this.tachograph.put(new Date(),this.user.getJoystickPosition(),controller.getReferenceSpeed());
	}

}
