package hu.bme.mit.train.interfaces;

import com.google.common.collect.HashBasedTable;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	HashBasedTable getTachograph();

	void setTachograph(String time, Integer joystick_posistion, Integer reference_speed);

}
