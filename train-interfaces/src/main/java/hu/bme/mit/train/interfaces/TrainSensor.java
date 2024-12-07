package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void recordTacho(int time, int joystickPosition, int referenceSpeed);

	int getTachoSize();
}
