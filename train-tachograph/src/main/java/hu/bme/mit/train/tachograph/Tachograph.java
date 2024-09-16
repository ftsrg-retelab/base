package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
public class Tachograph {
    Table<LocalDateTime, Integer, Integer> table = HashBasedTable.create();
    public void insert(int joystickPosition, int speed) {
        table.put(LocalDateTime.now(), joystickPosition, speed);
    }
}