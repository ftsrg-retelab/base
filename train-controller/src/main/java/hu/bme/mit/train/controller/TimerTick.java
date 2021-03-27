package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.TimerTask;

public class TimerTick extends TimerTask {
    private final TrainController controller;
    TimerTick(TrainController c)
    {
        super();
        controller = c;
    }

    @Override
    public void run() {
        controller.followSpeed();
    }
}
