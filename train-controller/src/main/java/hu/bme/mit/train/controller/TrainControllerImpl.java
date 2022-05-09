package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

class PeriodicRefSpeedChanger {


    private TrainController ctrl;

    public PeriodicRefSpeedChanger(TrainController ctrl) {
        this.ctrl = ctrl;
    }

    public void run() {
        try {
            while (true) {
                this.ctrl.followSpeed();
                Thread.sleep(2000);
            }
        }
        catch (Exception ex) {
            System.out.println("exception: "+ex.toString());
        }
    }

}


public class TrainControllerImpl implements TrainController {

    private int step = 0;
    private int referenceSpeed = 0;
    private int speedLimit = 0;
    private PeriodicRefSpeedChanger speedChanger;

    public TrainControllerImpl() {
        speedChanger = new PeriodicRefSpeedChanger();
        speedChanger.run();
    }

    @Override
    public void followSpeed() {
        if (referenceSpeed < 0) {
            referenceSpeed = 0;
        } else {
            if (referenceSpeed + step > 0) {
                referenceSpeed += step;
            } else {
                referenceSpeed = 0;
            }
        }

        enforceSpeedLimit();
    }

    @Override
    public int getReferenceSpeed() {
        return referenceSpeed;
    }

    @Override
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
        enforceSpeedLimit();

    }

    private void enforceSpeedLimit() {
        if (referenceSpeed > speedLimit) {
            referenceSpeed = speedLimit;
        }
    }

    @Override
    public void setJoystickPosition(int joystickPosition) {
        this.step = joystickPosition;
    }


    public void foo(String asd) {
        System.out.println(asd);
    }

}
