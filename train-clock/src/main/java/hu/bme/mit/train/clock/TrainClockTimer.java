package hu.bme.mit.train.clock;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.TimerTask;

public class TrainClockTimer extends TimerTask {

    private final TrainController controller;

    public TrainClockTimer(TrainController controller) {this.controller = controller; }

    @Override
    public void run() {
        controller.followSpeed();
    }


}
