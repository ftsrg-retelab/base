package hu.bme.mit.train.interfaces;
import com.google.common.collect.Table;
import java.time.LocalTime;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	LocalTime getCurrentTime();

	int getJoystickPosition();

	int getReferenceSpeed();

	void addToTable();
	
	int getTableSize();
}
