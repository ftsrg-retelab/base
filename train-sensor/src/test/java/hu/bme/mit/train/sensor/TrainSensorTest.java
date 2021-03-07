package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainSensor;

public class TrainSensorTest {


    TrainSensor sensor;
    TrainController tc;

    @Before
    public void before() {
        tc = new TrainControllerImpl();
        sensor = new TrainSensorImpl(tc,new TrainUserImpl(tc));
    }

    @Test
    public void SpeedLimitSetTest() {
        sensor.overrideSpeedLimit(45);
        Assert.assertEquals(45, sensor.getSpeedLimit());
    }
}
