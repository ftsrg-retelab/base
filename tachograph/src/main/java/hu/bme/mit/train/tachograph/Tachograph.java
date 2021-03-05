package hu.bme.mit.train.tachograph;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Date;

public class Tachograph {

    private Table<Date, Integer, Integer> TachoLog = HashBasedTable.create();

    public void record(Date time, Integer joyStickPosition, Integer referenceSpeed){
        TachoLog.put(time, joyStickPosition, referenceSpeed);
    }

}
