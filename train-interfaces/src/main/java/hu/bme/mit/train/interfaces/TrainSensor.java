package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	long getCurrentTime();

	int getReferenceSpeed();

	int getJoystickPosition();

	void updateTable();

	int getTableSize();
}
