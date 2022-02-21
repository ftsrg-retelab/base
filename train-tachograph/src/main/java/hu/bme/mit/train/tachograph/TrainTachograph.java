package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograph {
    private Table<Long, Integer, Integer> tachograph;

    public TrainTachograph(){
        tachograph = HashBasedTable.create();
    }

    public void addToTachograph(Integer joystickPosition, Integer referenceSpeed){
        tachograph.put(System.currentTimeMillis(), joystickPosition, referenceSpeed);
    }

    public Table<Long, Integer, Integer> getFromTachograph(){
        return tachograph;
    }
}