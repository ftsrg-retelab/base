package hu.bme.mit.train.system;

import hu.bme.mit.train.interfaces.TrainController;

public class MovingTrainThread implements Runnable{

    private TrainController controller;

    private boolean stop = false;

    public MovingTrainThread(TrainController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while(!stop) {
            controller.followSpeed();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        stop = true;
    }
}
