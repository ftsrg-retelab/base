package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import java.time.LocalDateTime; 

public class Tachograph {
    
    public Table<LocalDateTime, Integer, Integer> tachograph = HashBasedTable.create();

    public void add(int joystick, int speed){
        tachograph.put(LocalDateTime.now(), joystick, speed);
    } 

} 