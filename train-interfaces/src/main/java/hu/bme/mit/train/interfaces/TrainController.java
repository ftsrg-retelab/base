package hu.bme.mit.train.interfaces;

import java.util.TimerTask;

public interface TrainController  {

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
