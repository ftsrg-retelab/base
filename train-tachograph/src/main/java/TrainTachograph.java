import com.google.common.collect.*;
import java.time.LocalDateTime;


public class TrainTachograph {
    private Table<LocalDateTime, Integer, Integer> tachograph;

    public TrainTachograph(){
        tachograph = HashBasedTable.create();
    }

    public void AddTachograph(Integer joyStick, Integer referenceSpeed){
        tachograph.put(LocalDateTime.now(), joyStick, referenceSpeed);
    }

    public Table<LocalDateTime, Integer, Integer> GetTachograph(){
        return tachograph;
    }
}
