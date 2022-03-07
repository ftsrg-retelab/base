package hu.bme.mit.train.tachnograph;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

import java.util.Iterator;

public class Tachnograph {
    private static Table<Long, Integer, Integer> table = HashBasedTable.create();

    public static void addData(Integer joystickPosition, Integer referenceSpeed) {
        table.put(System.currentTimeMillis(), joystickPosition, referenceSpeed);
    }

    public static boolean hasData() {
        return !table.isEmpty();
    }

    public static Integer getReferenceSpeedSet() {
        Iterator<Integer> iterator = table.values().iterator();
        Integer value = null;
        while(iterator.hasNext()) {
            value = iterator.next();
        }
        return value;
    }
}