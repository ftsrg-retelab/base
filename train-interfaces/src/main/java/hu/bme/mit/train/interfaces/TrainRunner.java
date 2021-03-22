package hu.bme.mit.train.interfaces;

import java.util.TimerTask;

public abstract class TrainRunner extends TimerTask {

    abstract public void schedule(long period);
}
