package hu.bme.mit.train.interfaces;
import com.google.common.collect.Table;
import java.time.*;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void recordData();

	public Table<LocalTime, Integer, Integer> getTachograph();
}
