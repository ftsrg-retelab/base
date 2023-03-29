package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;

import java.util.Date;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);
	void saveValues();
	Table<Date,Integer,Integer> getTachograph();
}
