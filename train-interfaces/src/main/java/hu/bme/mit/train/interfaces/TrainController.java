package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	int getTime();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

	void setBreaks(boolean breakPosition);
}
