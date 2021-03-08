package hu.bme.mit.train.tachograph;

import java.time.LocalDateTime;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainTachograph;

public class TrainTachographImpl implements TrainTachograph {

	Table<LocalDateTime, int, int> TachographTable = HashBasedTable.create();

	public void putTachographTable() {
	LocalDateTime currentTime = LocalDateTime.now();
	TachographTable.put(currentTime, user.getJoystickPosition(), controller.getReferenceSpeed());
	}
}
