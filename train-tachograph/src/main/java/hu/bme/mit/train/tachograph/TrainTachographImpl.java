package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainTachograph;
import hu.bme.mit.train.interfaces.TrainUser;

import java.sql.Timestamp;
import java.util.Date;

public class TrainTachographImpl implements TrainTachograph {

    private TrainController controller;
    private TrainUser user;
    private Date startDate;
    private int numberOfLogs;
    private Table<Date, Integer, Integer> logEntries;

    public TrainTachographImpl(TrainController controller, TrainUser user){
        this.controller = controller;
        this.user = user;
        this.startDate = new Date();
        this.logEntries = TreeBasedTable.create();
        this.numberOfLogs = 0;
    }

    @Override
    public boolean recordData() {
        Timestamp ts = new Timestamp(startDate.getTime() + numberOfLogs++ * 1000);
        int refSpeed = controller.getReferenceSpeed();
        int jsPosition = user.getJoystickPosition();
        return logEntries.put(ts, refSpeed, jsPosition) == null;
    }

    @Override
    public int getData() {
        return logEntries.size();
    }

    @Override
    public boolean isEmpty() {
        return logEntries.isEmpty();
    }
}
