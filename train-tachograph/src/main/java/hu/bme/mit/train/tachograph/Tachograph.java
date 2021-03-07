package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainTachograph;

import java.time.LocalDateTime;

public class Tachograph implements TrainTachograph {
    Table<LocalDateTime, Integer, Integer> mTable = HashBasedTable.create();

    public void add(int joystickPos, int speed) {
        mTable.put(LocalDateTime.now(), joystickPos, speed);
    }
}


