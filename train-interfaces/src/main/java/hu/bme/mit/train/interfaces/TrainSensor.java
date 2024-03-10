package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);
	void addRecord(String date, Integer joystickPosition, Integer referenceSpeed);
}
