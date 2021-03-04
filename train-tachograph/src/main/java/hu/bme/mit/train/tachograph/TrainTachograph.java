package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;

public class TrainTachograph {

    private static TrainTachograph instance;
    private TrainTachograph(){
        TachoTable = HashBasedTable.create();
    };
    public static TrainTachograph getInstance(){
        if (instance == null) {
            instance = new TrainTachograph();
        }
        return instance;
    }



    private Table<LocalDateTime, Integer, Integer> TachoTable;

    public Table<LocalDateTime, Integer, Integer> getTachoTable() {
        return TachoTable;
    }

    public void AddEntry(LocalDateTime time, Integer joystickPosition, Integer trainSpeed ) {
        this.TachoTable.put(time, joystickPosition, trainSpeed);
    }

}
