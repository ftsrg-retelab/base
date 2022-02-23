package hu.bme.mit.train.controller;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;

public class Tachometer {
    Table<LocalDateTime, Integer, Integer> table;

    public Tachometer() {
        table = HashBasedTable.create();
    }

    public void addDataToTachometer(int joystickPosition, int referenceSpeed){
        table.put(LocalDateTime.now(), joystickPosition,referenceSpeed);
    }

    public boolean isEmpty(){
        return table.isEmpty();
    }
}
