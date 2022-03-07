package hu.bme.mit.train.tachnograph;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class Tachnograph {
    private static Table<Long, Integer, Integer> table = HashBasedTable.create();

    public static void addData(Integer joystickPosition, Integer referenceSpeed) {
        table.put(System.currentTimeMillis(), joystickPosition, referenceSpeed);
    }

    public static Table<Long, Integer, Integer> getTable() {
        return table;
    }
}