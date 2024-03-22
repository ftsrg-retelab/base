package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void setAlarmState(boolean alarmState);

	boolean getAlarmState();

	void overrideJoystickPosition(int joystickPosition);

}
