package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	boolean newFeature();

	void overrideJoystickPosition(int joystickPosition);

}
