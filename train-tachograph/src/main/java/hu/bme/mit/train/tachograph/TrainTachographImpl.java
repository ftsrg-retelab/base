package hu.bme.mit.train.tachograph;

import java.time.LocalDateTime;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainTachograph;

public class TrainTachographImpl implements TrainTachograph {

	private Table<LocalDateTime, Integer, Integer> TachographTable = HashBasedTable.create();

	public Object getTachographTable() {
		return this.TachographTable;
	}

	public void putTachographTable(int joystickPosition, int referenceSpeed) {
	LocalDateTime currentTime = LocalDateTime.now();
	TachographTable.put(currentTime, joystickPosition, referenceSpeed);
	}
}
