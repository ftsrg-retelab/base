package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;

public interface TrainSensor {

	int getSpeedLimit();

	Table<Integer, Integer, Integer> getTachograf();

	void overrideSpeedLimit(int speedLimit);

	void saveCurrentState();
}
