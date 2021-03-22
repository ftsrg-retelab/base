package hu.bme.mit.train.runner;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainRunner;

import java.util.Date;
import java.util.Timer;

public class TrainRunnerImpl extends TrainRunner {


    private final TrainController controller;

    private final Timer timer;

    public TrainRunnerImpl(TrainController controller){
        this.controller = controller;
        this.timer = new Timer();
    }

    @Override
    public void run(){
        controller.followSpeed();
    }

    public void schedule(long period){
        this.timer.schedule(this, new Date(), period);
    }
}
