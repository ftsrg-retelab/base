package hu.bme.mit.train.tachograf;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograf {

	private TrainControllerImpl c = new TrainControllerImpl();
	private TrainUser u = new TainUser();
	private Table<Date, int, int> tachografTable = ImmutableTable.<String, int, int> builder().put(new Date(), u.getJoystickPosition(), c.getReferenceSpeed()).build();
	
	//tachografTable.put(new Date(), u.getJoystickPosition(), c.getReferenceSpeed());
	
	public Table<String, int, int> getTachografTable() {
		return tachografTable;
	}
}
