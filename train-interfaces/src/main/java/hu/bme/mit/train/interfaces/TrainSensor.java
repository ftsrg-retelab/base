package hu.bme.mit.train.interfaces;

import java.time.LocalDateTime;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void dangerDetection(boolean hazard);

	public void logTachograph();

	public int getLogSize();

}
