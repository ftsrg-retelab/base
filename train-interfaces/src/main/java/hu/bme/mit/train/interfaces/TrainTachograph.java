package hu.bme.mit.train.interfaces;

public interface TrainTachograph {
    void updateTachograph(Integer time, String direction, Integer speed);
}
