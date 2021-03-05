import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;


public class TrainTachograph {
    private  Table<LocalDateTime, Integer, Integer> tachograph = HashBasedTable.create();

    public void updateTable(int joystickPos, int refSpeed){
        tachograph.put(LocalDateTime.now(), joystickPos, refSpeed);
    }

    public Table<LocalDateTime, Integer, Integer> getTable(){
        return tachograph;
    }
}
