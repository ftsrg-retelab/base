package hu.bme.mit.train.interfaces;
import java.util.Date;
import com.google.common.collect.HashBasedTable; 
import com.google.common.collect.Table; 

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

	void setSpeedBoostActive(boolean speedBoostActive);
	
	Table<Date, Integer, Integer> getLogTable();

}
