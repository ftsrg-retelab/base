package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);

	void emergencybreaks();

	void setAlarmState(boolean state);

	boolean getAlarmState();

}
