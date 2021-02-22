package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	int getSpeedLimit();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
