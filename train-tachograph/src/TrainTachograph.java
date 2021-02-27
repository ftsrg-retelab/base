import java.util.Date;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograph {
    private Table<Date, Integer, Integer> tachograph;

    public TrainTachograph(){
        tachograph = HashBasedTable.create();
    }

    public void addNewRecord(Integer joyposition, Integer speed){
        Date date=new Date();
        tachograph.put(date, joyposition, speed);
    }

    public Table<Date, Integer, Integer> readTable(){
        return tachograph;
    }
}