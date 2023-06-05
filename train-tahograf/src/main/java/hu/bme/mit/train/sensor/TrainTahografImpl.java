package hu.bme.mit.train.tahograf;

import hu.bme.mit.train.interfaces.TrainController;
import java.time.LocalDate;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;


public class TrainTahografImpl{
	private TrainController trainController;
	private TrainUser trainUser;
	private Table<LocalDate, Integer, Integer> tahoGrafTable; 

	public TrainTahografImpl() {
		tahoGrafTable = HashBasedTable.create();
	}

	public Table getTable(){
		return tahoGrafTable;
	}
	public void sampleData() {
		tahoGrafTable.put(LocalDate.now(),
		trainUser.getJoystickPosition(),
		trainController.getReferenceSpeed());
	}
}
