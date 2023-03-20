package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

import java.time.LocalDateTime;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	Table<LocalDateTime, Integer, Integer> tabla =  HashBasedTable.create();

	public Table<LocalDateTime, Integer, Integer> getTable() {
		return tabla;
	}
	
	public void  putTable(LocalDateTime time) {
		tabla.put(time, user.getJoystickPosition(), controller.getReferenceSpeed());
	}
}
