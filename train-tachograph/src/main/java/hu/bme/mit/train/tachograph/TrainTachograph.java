package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;

import java.time.LocalTime;


public class TrainTachograph {

    private TrainController controller = new TrainControllerImpl();
    private TrainUser user = new TrainUserImpl(controller);
    private Table<LocalTime, Integer, Integer> table;

    public TrainTachograph() {
        table = HashBasedTable.create();
        table.put(java.time.LocalTime.now(), user.getJoystickPosition(), controller.getReferenceSpeed());
    }

    public boolean TableIsEmpty(){
        return table.isEmpty();
    }
}
