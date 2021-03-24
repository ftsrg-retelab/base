package hu.bme.mit.train.clock;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;

public class TrainClockTimer extends Thread {

    private final TrainController controller;
    public TrainClockTimer(TrainController controller) {this.controller = controller; this.start();}

    public void run() {
        System.out.println("Thread started----");
        while (true){
            System.out.println("--Thread called");
            System.out.println("Speed: " + controller.getReferenceSpeed());
            controller.followSpeed();
            System.out.println("--Speed++");
            System.out.println("Speed: " + controller.getReferenceSpeed());
            try {
                Thread.sleep(100);
            }
            catch (Exception ignored){
                System.out.println("---INTERRUPT");
                continue;
            };
        }
    }




}
