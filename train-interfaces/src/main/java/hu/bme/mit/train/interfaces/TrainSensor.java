package hu.bme.mit.train.interfaces;
import com.google.common.collect.Table;
import java.time.LocalTime;
import com.google.common.collect.HashBasedTable;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void tachoGraf();

	int size();

}
