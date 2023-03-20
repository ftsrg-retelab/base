package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import guava.Table;

public class TrainTahografImpl{

	Table<Date, Double, Integer> tahoGrafTable; 


	public TrainTahografImpl() {
		tahoGrafTable = HashBasedTable.create();
	}

	public Table getTable(){
		return tahoGrafTable();
	}


}
