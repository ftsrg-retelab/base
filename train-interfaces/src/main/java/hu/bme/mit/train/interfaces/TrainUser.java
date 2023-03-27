package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void turnEmergencyBreakOn();

	void turnEmergencyBreakOff();

	void overrideJoystickPosition(int joystickPosition);

}
