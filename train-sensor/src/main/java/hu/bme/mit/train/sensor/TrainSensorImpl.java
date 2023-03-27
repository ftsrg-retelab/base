package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

    private final TrainController controller;
    private final TrainUser user;
    private int speedLimit = 5;

    public TrainSensorImpl(TrainController controller, TrainUser user) {
        this.controller = controller;
        this.user = user;
    }

    @Override
    public int getSpeedLimit() {
        return speedLimit;
    }

    @Override
    public void overrideSpeedLimit(int speedLimit) {
        // Absolute margin
        if (speedLimit < 0 || speedLimit > 500) {
            user.setAlarmState(true);
        }
        // Relative margin
        float speedChangeRatio = (float) speedLimit / this.speedLimit;
        if (speedChangeRatio < 0.5 || 1.5 < speedChangeRatio) {
            user.setAlarmState(true);
        }
        this.speedLimit = speedLimit;
        controller.setSpeedLimit(speedLimit);
    }

}
