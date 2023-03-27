package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainSensorTest {

    TrainController controller;

    TrainSensor sensor;

    @Before
    public void before() {
        controller = new TrainControllerImpl();
        sensor = new TrainSensorImpl(controller, new TrainUserImpl(controller));

		sensor.overrideSpeedLimit(50);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        sensor.saveCurrentState();
        Assert.assertFalse(sensor.getTachograf().isEmpty());
        Assert.assertTrue(sensor.getTachograf().containsValue(0));
        Assert.assertFalse(sensor.getTachograf().containsValue(1));
    }
}
