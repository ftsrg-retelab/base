package hu.bme.mit.train.interfaces;
import com.google.guava.*;
import java.util.Map;
import java.util.Set;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	Table<LocalDateTime, int, int> getTachografRecordings();

}
