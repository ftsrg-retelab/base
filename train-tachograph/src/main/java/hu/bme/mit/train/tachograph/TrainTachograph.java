package hu.bme.mit.train.tachograph;

import java.util.Date;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograph {
    private Table<Date, Integer, Integer> tachograph;

    public TrainTachograph(){
        tachograph = HashBasedTable.create();
    }

    public void addToTachograph(Integer joystickPosition, Integer referenceSpeed){
        tachograph.put(new Date(), joystickPosition, referenceSpeed);
    }

    public Table<Date, Integer, Integer> getFromTachograph(){
        return tachograph;
    }
}
