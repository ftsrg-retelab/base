package hu.bme.mit.train.tachograph;


import java.time.LocalTime;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;


public class TrainTachograph {
	
	private Table<LocalTime, Integer, Integer> logTable;
	
	
	public TrainTachograph() {
		logTable = HashedBaseTable.create();
	}
	
	public void add(int userJoyStickPos, int controllerRefSpeed) {
		LocalTime time = LocalTime.now();
		logTable.put(time, userJoyStickPos, controllerRefSpeed);
	}
}
