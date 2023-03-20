package hu.bme.mit.train.interfaces;
import com.google.common.collect.Table;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

	void emergencyBrake();

	void saveTachographData();

	public Table<Integer, Integer, Integer> getTachographData();
}
