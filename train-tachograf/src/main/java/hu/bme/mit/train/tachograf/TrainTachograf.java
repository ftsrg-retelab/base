package hu.bme.mit.train.tachograf;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograf {

	private TrainController c = new TrainController();
	private TainUser u = new TainUser();
	public Table<Date, reference, reference> tachografTable = ImmutableTable.<String, reference, reference> builder().put(new Date(), u.getJoystickPosition(), c.getReferenceSpeed()).build();
	
	//tachografTable.put(new Date(), u.getJoystickPosition(), c.getReferenceSpeed());
	
	public Table<String, reference, reference> getTachografTable() {
		return tachografTable;
	}
}
