package hu.bme.mit.train.tachograph;


import java.time.LocalTime;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;


public class TrainTachograph {
	
	private Table<LocalTime, Integer, Integer> logTable;
	
	
	public TrainTachograph() {
		logTable = HashBasedTable.create();
	}
	
	public void add(int userJoyStickPos, int controllerRefSpeed) {
		LocalTime time = LocalTime.now();
		logTable.put(time, userJoyStickPos, controllerRefSpeed);
	}
	
	public boolean isEmpty() {
		return logTable.isEmpty();
	}
}
