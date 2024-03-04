package hu.bme.mit.train.interfaces;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import java.util.Set;
import java.time.LocalDateTime;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	Table<LocalDateTime, Integer, Integer> getTachografRecordings();

}
