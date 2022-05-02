package hu.bme.mit.train.tachograph;

import java.util.Date;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainTachograph {

    private TrainController trainController;
    private TrainUser trainUser;
    private Table<Date, Integer, Integer> recordTable = HashBasedTable.create();

    public TrainTachograph() {
        trainController = new TrainControllerImpl();
        trainUser = new TrainUserImpl(trainController);
    }

    public Table<Date, Integer, Integer> getRecordTable() {
        return Tables.unmodifiableTable(recordTable);
    }

    public void record() {
        recordTable.put(new Date(), trainUser.getJoystickPosition(), trainController.getReferenceSpeed());
    }
}