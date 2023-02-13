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
	private Table<LocalDateTime, Integer, Integer> datas = HashBasedTable.create();

	void add(LocalDateTime currentTime, Integer position, Integer speed) {
		datas.put(currentTime, position, speed);
	}

	Integer get(LocalDateTime time, Integer position) {
		return datas.get(time, position);
	}
}