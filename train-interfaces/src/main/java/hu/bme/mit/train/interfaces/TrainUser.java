package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	Void overrideJoystickPosition(int joystickPosition);

}
