package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import java.time.LocalDateTime;
import java.util.Date;

public class TrainTachograph {
    private Table<Date, Integer, Integer> tachographTable;

    public TrainTachograph(){
        tachographTable = HashBasedTable.create();
    }

    public void add(Integer joypos, Integer speed){
        tachographTable.put(new Date(), joypos, speed);
    }

    public Table<Date, Integer, Integer> get(){
        return tachographTable;
    }
}
