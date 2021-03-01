package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograph {

    Table<Integer, String, Integer> records;

    public TrainTachograph() {
        records = HashBasedTable.create();
    }

    public void addRecord(int time, String position, int speed) {
        records.put(time, position, speed);
    }
}
