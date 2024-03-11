package hu.bme.mit.train.interfaces;

public interface TrainController {

	Table<Date, Integer, Integer> tachograph= HashBasedTable.create();

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

	public void setEmergencyBrake(boolean EmergencyBrake);

}
