package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainTachograph;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;


public class TrainTachographImpl implements TrainTachograph {

    private Table<Integer, String, Integer> table = HashBasedTable.create(); 

    @Override
    public void setValueAtTimestep (int time, String type, int value) {
        table.put(time, type, value);
    }

    @Override
    public int getValueAtTimestep (int time, String type) {
        return table.get(time, type);
    }
}