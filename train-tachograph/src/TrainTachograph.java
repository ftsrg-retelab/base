import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograph {
    Table <String, String, String> tachographTable = HashBasedTable.creat();

    public TrainTachograph(String currentTime, String joystickPosition, String referenceSpeed) {
        tachographTable.put(currentTime,joystickPosition,referenceSpeed);
    }
}
