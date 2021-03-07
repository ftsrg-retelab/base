package hu.bme.mit.train.tachograph;

import com.google.common.collect.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TrainTachograph {
	private Table<LocalDateTime, Integer, Integer> tachograph;
	private int size = 0;

	public TrainTachograph() {
		tachograph = HashBasedTable.create();
	}

	public TrainTachograph getTrainTachograph(){
		return this;
	}

	public void addRecord(int pos, int speed){
		LocalDateTime now = LocalDateTime.now();
		tachograph.put(now, pos, speed);
		size++;
	}

	public int getSize(){
		return this.size;
	}
}
