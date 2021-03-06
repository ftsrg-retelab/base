package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainTaco;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.tacho.TrainTachoImp;
import hu.bme.mit.train.user.TrainUserImpl;

import java.util.Date;

public class TrainSystem {

	private Table<Integer, Integer, Date> guavaTable = HashBasedTable.create();
	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private TrainTaco tacho = new TrainTachoImp(controller);

	public Table<Integer, Integer, Date> getGuavaTable() {
		return guavaTable;
	}

	public void setGuavaTable(Table<Integer, Integer, Date> guavaTable) {
		this.guavaTable = guavaTable;
	}

	public void addToTable(Integer position, Integer speed, Date time) {
		this.guavaTable.put(position, speed, time);
	}

	public TrainTaco getTacho() {
		return tacho;
	}

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}


	public void setController(TrainControllerImpl a) {
		this.controller = a;
	}

	public void setSensor(TrainSensorImpl b) {
		this.sensor = b;
	}

	public void setUser(TrainUserImpl c) {
		this.user = c;
	}

}
