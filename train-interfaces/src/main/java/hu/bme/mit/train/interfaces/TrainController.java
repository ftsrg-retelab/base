package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();
	//comment test

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
