package hu.bme.mit.train.tachogaph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Date;
import java.util.Map;

public class TachographModule {

    Table<Date,Integer, Integer> data = HashBasedTable.create();

    public void RecordData(int joystick, int speed){
        RecordData(new Date(),joystick,speed);
    }

    public void RecordData(Date d, int joystick, int speed){
        data.put(d,joystick,speed);
    }

    public Map<Integer, Integer> GetData(Date d){
        return data.row(d);
    }

}
