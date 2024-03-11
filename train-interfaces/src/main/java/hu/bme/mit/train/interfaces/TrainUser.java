package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();
	boolean getEmergencyBreak();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);
	void setEmergencyBreak(boolean val);


}
