package hu.bme.mit.train.interfaces;
import java.time.*;
import com.google.common.collect.Table;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void setTachograph();

	Table<LocalTime,Integer,Integer> getTachograph();
}
