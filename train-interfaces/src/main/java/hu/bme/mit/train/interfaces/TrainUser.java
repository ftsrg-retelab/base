package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getSpeedBoostActive();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);

	void overrideSpeedBoostActive(boolean speedBoostActive);

}
