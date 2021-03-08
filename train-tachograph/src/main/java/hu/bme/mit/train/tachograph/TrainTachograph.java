package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

import java.time.LocalTime;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;


public class TrainTachograph {
	
	private TrainController controller;
	private TrainUser user;
	private Table<LocalTime, Integer, Integer> logTable;
	
	
	public Tachograph() {
		controller = new TrainControllerImpl();
		user = new TrainUserImpl(controller);
		logTable = HashedBaseTable.create();
	}
	
	public void add(int userJoyStickPos, int controllerRefSpeed) {
		LocalTime time = LocalTime.now();
		logTable.put(time, userJoyStickPos, controllerRefSpeed);
	}
}
