package hu.bme.mit.train.tachograph;

import com.google.common.collect.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TrainTachograph {
	private final Table<LocalDateTime, Integer, Integer> tachograph;

	public TrainTachograph() {
		tachograph = ImmutableTable.<LocalDateTime, Integer, Integer>builder()
				.build();
	}

	public TrainTachograph getTrainTachograph(){
		return this;
	}

	public void addRecord(int pos, int speed){
		LocalDateTime now = LocalDateTime.now();
		tachograph.put(now, pos, speed);
	}

	public int getSize(){
		return this.tachograph.size();
	}
}
