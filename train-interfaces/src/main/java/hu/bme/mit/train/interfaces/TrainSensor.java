package hu.bme.mit.train.interfaces;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void addToTachograph(int currentTime, int joystickPosition, int speed);

	Table<Integer, Integer, Integer> getTacho();

}
