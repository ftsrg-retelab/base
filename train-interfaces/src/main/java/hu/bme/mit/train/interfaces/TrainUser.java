package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);

	// method added to set the alarm flag
	void setAlarmFlag(boolean alarmFlag);

}
