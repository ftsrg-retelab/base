package hu.bme.mit.train.interfaces;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	public void logStatus();

	public Table<Integer, Integer, Integer> getStatusHistory();

}
