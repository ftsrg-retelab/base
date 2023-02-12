package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;

public class Tachograph {
	/*
		current time
		joystick position
		reference speed
	*/
	private Table<LocalDateTime, Double, Double[]> datas = HashBasedTable.create();

	void add(LocalDateTime currentTime, Double positionX, Double positionY, Double speed) {
		datas.put(currentTime, speed, new Double[] {positionX, positionY});
	}

	Double[] get(LocalDateTime time, Double speed) {
		return datas.get(time, speed);
	}
}