package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;


import java.time.LocalTime;

public class Tachograph {
    private int counter = 0;
    Table<LocalTime, Integer, Integer> tachoTable
            = TreeBasedTable.create();

    public void add(Integer jspos, Integer refspeed){
        LocalTime now = LocalTime.now();
        tachoTable.put(now, jspos, refspeed);
    }

    public Boolean isEmpty(){
        return tachoTable.isEmpty();
    }
}
