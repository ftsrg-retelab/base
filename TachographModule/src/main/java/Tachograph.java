import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import java.time.LocalTime;

public class Tachograph {
    //table
   public Table<LocalTime,Integer,Integer> tachographTable;

   //constructor()
   public Tachograph(){
       tachographTable = TreeBasedTable.create();
   }

   //add()
    public void add(Integer joystickPosition, Integer referenceSpeed){
       LocalTime _localTime = LocalTime.now();
       tachographTable.put(_localTime,joystickPosition,referenceSpeed);
    }

    //isEmpty()
    public boolean isEmpty(){
        return tachographTable.isEmpty();
    }
}

