package hu.bme.mit.train.tachograf;

import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainController;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import java.time.LocalTime;

public class Tacho {
    
    private TrainController controller;
    private TrainUser user;
    private Table<LocalTime, Integer, Integer> tachoTable;
    
    public Tacho(TrainController controller, TrainUser user) {
        this.controller = controller;
        this.user = user;
        this.tachoTable = HashBasedTable.create();
    }
    
    public void addEntry() {
        tachoTable.put(LocalTime.now(), controller.getReferenceSpeed(), user.getJoystickPosition());
    }

    public Table<LocalTime, Integer, Integer> getTachoTable() {
        return tachoTable;
    }

}