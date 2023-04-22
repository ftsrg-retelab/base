package hu.bme.mit.train.interfaces;

public interface TrainController {

	void periodic_reference_speedChange();

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

	void setOverrideSpeed(boolean var);
}
