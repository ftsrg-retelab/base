package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	public void tick( String ido, int joystickPosition, int referenceSpeed);

	void overrideSpeedLimit(int speedLimit);

}
