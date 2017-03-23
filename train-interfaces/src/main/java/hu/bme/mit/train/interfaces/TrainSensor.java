package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	Void overrideSpeedLimit(int speedLimit);

}
