package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);

	Table<String, String, String> tachographTable = HashBasedTable.create();
	
	public TrainSystem() {
		tachographTable.put("2020-02-02", "123456", "12345677");
		tachographTable.put("20201-02-03", "2235", "3563");
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

	public String getTachographTable() {
		return tachographTable.get("2020-02-02", "123456"); 
	} 

}
