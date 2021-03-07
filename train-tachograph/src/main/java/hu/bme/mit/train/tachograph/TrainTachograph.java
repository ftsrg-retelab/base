package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Date;

public class TrainTachograph {
    Table<Date, Integer, Integer> tachograph = HashBasedTable.create();

    void addPosAndSpeed(Integer pos, Integer speed){
        tachograph.put(new Date(), pos, speed);
    }
    int getElementCount(){
        return tachograph.size();
    }
}
