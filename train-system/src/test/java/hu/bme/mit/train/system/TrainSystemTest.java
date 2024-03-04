package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

import java.time.*;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class TrainSystemTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();

		sensor.overrideSpeedLimit(50);
	}
	
	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
		sensor.overrideSpeedLimit(10);

		Assert.assertEquals(0, controller.getReferenceSpeed());
		
		user.overrideJoystickPosition(5);

		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}

	@Test
	public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

	@Test
	public void EmergencyBreak() {
		user.overrideJoystickPosition(-2);
		controller.followSpeed();
		Assert.assertEquals(0,controller.getReferenceSpeed());
	}

	@Test
	public void NewTestCase() {
		sensor.overrideSpeedLimit(10);
		user.overrideJoystickPosition(20);
		controller.followSpeed();
		Assert.assertEquals(10,controller.getReferenceSpeed());
	}

	@Test
    public void TachoGraph() {
        user.overrideJoystickPosition(5);
		controller.followSpeed();
        user.overrideJoystickPosition(15);
        sensor.setTachograph();
        Table<LocalTime,Integer,Integer> tachograph = sensor.getTachograph();
        Assert.assertEquals(1, tachograph.size());
    }
	
}
