package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;

public class TrainSensorTest {

    TrainSensor sensor = new TrainSensorImpl(new TrainControllerImpl(), new TrainUserImpl());

    @Before
    public void before() {

		sensor.overrideSpeedLimit(50);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        Assert.assertEquals(true, true);
    }
}
