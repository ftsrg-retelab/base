package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;
import java.time.LocalDateTime;


public interface TrainTachograph {

	public Table<LocalDateTime, Integer, Integer> getTachographTable();

	void putTachographTable(int joystickPosition, int referenceSpeed);

}