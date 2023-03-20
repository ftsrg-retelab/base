package hu.bme.mit.train.tachograph;

import java.util.Date;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.system.TrainSystem;

public class TrainTachograph {

	private TrainController controller;
	private TrainUser user;
	private TrainSensor sensor;

	private Table<Date, Integer, Integer> table;

	public TrainTachograph(TrainSystem system) {
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
		table = TreeBasedTable.create();
	}

	public void record() {
		Date now = new Date(System.currentTimeMillis() / 100 * 100); // reducing pecision
		int joystickPosition = user.getJoystickPosition();
		int referenceSpeed = controller.getReferenceSpeed();
		table.put(now, joystickPosition, referenceSpeed);
	}

	public int report(Date when, int joystickPosition) {
		return table.get(when, joystickPosition);
	}
}
