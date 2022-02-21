package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void decreaseReferenceSpeed(int speed);

	void setJoystickPosition(int joystickPosition);

}
