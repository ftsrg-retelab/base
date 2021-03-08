package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	int getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);


}
