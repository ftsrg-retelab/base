package hu.bme.mit.train.interfaces;

public interface TrainUser {

	boolean alarmState = false;

	int getJoystickPosition();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);

	public boolean getAlarmState();

	public void setAlarmState(boolean alarmState);

}
