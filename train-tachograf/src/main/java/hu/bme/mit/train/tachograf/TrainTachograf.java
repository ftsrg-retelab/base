package hu.bme.mit.train.tachograf;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograf {

	private TrainController c = new TrainController();
	private TrainUser u = new TainUser();
	private Table<String, int, int> tachografTable = HashBasedTable.create();
	
	tachografTable.put((new Date()).toString(), u.getJoystickPosition(), c.getReferenceSpeed());
	
	public Table<String, int, int> getTachografTable() {
		return tachografTable;
	}
}
