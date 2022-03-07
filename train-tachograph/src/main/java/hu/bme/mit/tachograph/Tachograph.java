package hu.bme.mit.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import java.util.Date;

public class Tachograph {
    Table<Date, Integer, Integer> tachographTable = HashBasedTable.create();

    public Table<Date, Integer, Integer> getTachographTable(){
        return tachographTable;
    }

    public void add(Date date, Integer pos, Integer speed){
        tachographTable.put(date, pos, speed);
    }
}
