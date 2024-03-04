package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

import static org.mockito.Mockito.*;


public class TrainSensorTest {

    TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();

        sensor.overrideSpeedLimit(10);
	}

    @Test
	public void TachographTest() {
        sensor.logStatus();

		user.overrideJoystickPosition(5);
		controller.followSpeed();
        sensor.logStatus();

        controller.followSpeed();
        sensor.logStatus();

		Assert.assertEquals(10, controller.getReferenceSpeed());

		user.emergencyBreak();
        sensor.logStatus();

		Assert.assertEquals(0, controller.getReferenceSpeed());

        Assert.assertFalse(sensor.getStatusHistory().isEmpty());
	}

}
