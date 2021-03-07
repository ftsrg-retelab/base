package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

    private TrainController mController;
    private TrainUser mUser;
    private int mSpeedLimit = 5;

    public TrainSensorImpl(TrainController controller, TrainUser user) {
        this.mController = controller;
        this.mUser = user;
    }

    @Override
    public int getSpeedLimit() {
        return mSpeedLimit;
    }

    @Override
    public void overrideSpeedLimit(int speedLimit) {
        this.mSpeedLimit = speedLimit;
        mController.setSpeedLimit(speedLimit);
    }

}
