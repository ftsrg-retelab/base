package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;

public class TrainTachgraph {
    private Table<LocalDateTime, Integer, Integer> tachograph = HashBasedTable.create();

    public void add(int joystick, int speed){
        tachograph.put(LocalDateTime.now(), joystick, speed);
    }

    public boolean isEmpty(){
        return tachograph.isEmpty();
    }
}
