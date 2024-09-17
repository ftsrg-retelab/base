package hu.bme.mit.train.tachograph;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.sql.Time;

public class TrainTachographImpl {
    private Table<Time, Integer, Integer> TachographTable
            = HashBasedTable.create();
    public void insertValue(Time time, int joystickPos, int refSpeed)
    {
        TachographTable.put(time,joystickPos,refSpeed);
    }

    public int numberOfRecords()
    {
        return TachographTable.size();
    }




}
