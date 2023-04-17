package hu.bme.mit.train.system;

import hu.bme.mit.train.interfaces.TrainController;

public class WorkerThread extends Thread{
    private TrainController controller;
    public WorkerThread(TrainController controller) {
        super();
        this.controller = controller;
    }
    @Override public void run(){
        while(true){
            controller.followSpeed();
            try {
                Thread.sleep(MAX_PRIORITY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
