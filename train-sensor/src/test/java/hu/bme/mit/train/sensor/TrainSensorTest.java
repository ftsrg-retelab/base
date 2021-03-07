package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.sensor.TrainSensorImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
	
	TrainController controller;
	TrainUser user;
	TrainSensor sensor;

    @Before
    public void before() {
    	controller = new TrainControllerImpl();
    	user = new TrainUserImpl(controller);
    	sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void overrideSpeedLimitTest() {
        sensor.overrideSpeedLimit(10);
        Assert.assertEquals(10, sensor.getSpeedLimit());
 
    }
}
