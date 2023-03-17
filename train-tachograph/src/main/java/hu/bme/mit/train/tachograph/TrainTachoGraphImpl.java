package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.interfaces.TrainTachoGraph;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Date;


public class TrainTachoGraphImpl implements TrainTachoGraph {

	private Table<Long, Integer, Integer> statisticsTable = HashBasedTable.create();
	private TrainUser user;
	private TrainController controller;

	public TrainTachoGraphImpl(TrainController controller, TrainUser user){
		this.user = user;
		this.controller = controller;
	}

	@Override
	public void log(){
		statisticsTable.put(new Date().getTime(), user.getJoystickPosition(), controller.getReferenceSpeed());
	}

	@Override
	public Table<Long, Integer, Integer> getStatisticsTable(){
		return statisticsTable;
	}
}
