package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private HashBasedTable<String, Integer, Integer> tachograph = HashBasedTable.create();

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

	
	public HashBasedTable getTachograph(){
		return tachograph;
	}

	public void setTachograph(String time, Integer joystick_position, Integer reference_speed){
		tachograph.put(time, joystick_position, reference_speed);
	}


}
