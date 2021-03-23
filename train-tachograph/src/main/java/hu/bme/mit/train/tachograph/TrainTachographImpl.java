package hu.bme.mit.train.tachograph;

import java.time.LocalDateTime;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainTachograph;

public class TrainTachographImpl implements TrainTachograph {

	private Table<LocalDateTime, Integer, Integer> tachographTable = HashBasedTable.create();

	public Table<LocalDateTime, Integer, Integer> getTachographTable() {
		return this.tachographTable;
	}

	public void putTachographTable(int joystickPosition, int referenceSpeed) {
	LocalDateTime currentTime = LocalDateTime.now();
	tachographTable.put(currentTime, joystickPosition, referenceSpeed);
	}
}
