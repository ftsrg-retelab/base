package hu.bme.mit.train.interfaces;

public interface TrainController {

	void emergencyBrake();
	
	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
