package hu.bme.mit.train.tachograph;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.controller.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;

import java.util.Date;

public class TrainTachograph {
    private TrainController trainController;
    private TrainUser trainUser;
    private Table<Date, Integer, Integer> recordTable = HashBasedTable.create();

    public TrainTachograph() {
        trainController = new TrainControllerImpl();
        trainUser = new TrainUserImpl(trainController);
    }

    public Table<Date, Integer, Integer> getRecordTable() {
        return recordTable;
    }
}
