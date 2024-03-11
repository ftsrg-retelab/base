package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

    private int step = 0;
    private int referenceSpeed = 0;
    private int speedLimit = 0;

    // Flag to indicate whether speed limit has been reached
    private boolean speedLimitReached = false;

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

        // Check if speed limit has been reached
        if (referenceSpeed == speedLimit) {
            speedLimitReached = true;
        } else {
            speedLimitReached = false;
        }
    }

    @Override
    public int getReferenceSpeed() {
        return referenceSpeed;
    }

    @Override
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
        enforceSpeedLimit();

        // Check if speed limit has been reached after updating speed limit
        if (referenceSpeed == speedLimit) {
            speedLimitReached = true;
        } else {
            speedLimitReached = false;
        }
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

    // Method to check if speed limit has been reached
    @Override
    public boolean isSpeedLimitReached() {
        return speedLimitReached;
    
}