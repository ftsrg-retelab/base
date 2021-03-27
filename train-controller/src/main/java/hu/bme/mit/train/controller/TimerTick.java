package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.TimerTask;

public class TimerTick extends TimerTask {
    private TrainController controller;
    TimerTick(TrainController _controller)
    {
        super();
        controller = _controller;
    }

    @Override
    public void run() {
        controller.followSpeed();
    }
}
