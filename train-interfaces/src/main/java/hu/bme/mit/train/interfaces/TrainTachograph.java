package hu.bme.mit.train.interfaces;

public interface TrainTachograph {

	public Table<LocalDateTime, Integer, Integer> getTachographTable();

	void putTachographTable(int joystickPosition, int referenceSpeed);

}