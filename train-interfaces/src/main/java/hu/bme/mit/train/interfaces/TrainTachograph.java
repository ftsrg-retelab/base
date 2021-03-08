package hu.bme.mit.train.interfaces;

public interface TrainTachograph {

	public TrainTachograph getTachographTable();
	
	void putTachographTable(int joystickPosition, int referenceSpeed);

}