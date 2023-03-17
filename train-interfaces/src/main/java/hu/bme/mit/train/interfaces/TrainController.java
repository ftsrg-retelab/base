package hu.bme.mit.train.interfaces;

public interface TrainController {

	//public void setAlarm(boolean value);

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
