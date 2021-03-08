package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	boolean getEmergencyBrakeState();

	void overrideJoystickPosition(int joystickPosition);

	void switchBrakeState();

}
