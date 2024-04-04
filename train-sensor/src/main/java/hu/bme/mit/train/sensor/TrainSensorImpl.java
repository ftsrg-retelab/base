package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.Table;
import java.time.LocalTime;
import com.google.common.collect.HashBasedTable;


public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<LocalTime, Integer, Integer> courseSeatTable;


	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		courseSeatTable = HashBasedTable.create();
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
	public void tachoGraf(){
		
		
		courseSeatTable.put(LocalTime.now(), 10, 12);
	}

	public int size()
	{
		return courseSeatTable.size();
	}

}





