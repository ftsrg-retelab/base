package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.interfaces.TrainTachograph;
import com.google.common.collect.Table;

public class TrainTachographImpl implements TrainTachograph {

    private Table<Integer, String, Integer> tachograph;

    public TrainTachographImpl(Table<Integer, String, Integer> tachograph) {
        this.tachograph = tachograph;
    }

    @Override
    public void updateTachograph(Integer time, String direction, Integer speed) {
        tachograph.put(time, direction, speed);
    }
}
