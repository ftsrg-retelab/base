package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	public void setSpeedLimit(int speedLimit);
}
