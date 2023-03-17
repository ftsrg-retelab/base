package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;
public interface TrainTachoGraph {

    public void log();
    public Table<Long, Integer, Integer> getStatisticsTable();
}
