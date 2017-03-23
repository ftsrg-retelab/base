package hu.bme.mit.train.interfaces;

public interface TrainController {

	Void followSpeed();

	int getReferenceSpeed();

	Void setSpeedLimit(int speedLimit);

	Void setJoystickPosition(int joystickPosition);

}
