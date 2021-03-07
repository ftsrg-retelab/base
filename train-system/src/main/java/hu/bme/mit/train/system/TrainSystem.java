package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

    private TrainController mController = new TrainControllerImpl();
    private TrainUser mUser = new TrainUserImpl(mController);
    private TrainSensor mSensor = new TrainSensorImpl(mController, mUser);

    public TrainController getController() {
        return mController;
    }

    public TrainSensor getSensor() {
        return mSensor;
    }

    public TrainUser getUser() {
        return mUser;
    }

}
