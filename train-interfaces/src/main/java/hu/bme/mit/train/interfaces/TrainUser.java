package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmState();

	void setAlarmState(boolean state);

	void overrideJoystickPosition(int joystickPosition);

}
