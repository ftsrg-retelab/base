package hu.bme.mit.train.button;

import hu.bme.mit.train.interfaces.TrainButton;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;


public class TrainButtonImpl implements TrainButton{
    private TrainSensor sensor;
    public TrainButton (TrainSensor sensor0)
    {
        this.sensor = sensor0;
    }

    public int showSpeedLimit()
    {
        return this.sensor.speedLimit;
    }
}
