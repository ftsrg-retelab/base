package hu.bme.mit.train.interfaces;

public interface TrainTachograph {

    public void setValueAtTimestep (int time, String type, int value);
    public int getValueAtTimestep (int time, String type);
}
