package hu.bme.mit.train.system;

import hu.bme.mit.train.tachograph.TrainTachograph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

import java.security.PublicKey;

public class TrainSystemTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	TrainTachograph tachograph;
	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
		tachograph = system.getTachograph();

		sensor.overrideSpeedLimit(50);
	}
	
	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
		sensor.overrideSpeedLimit(15);

		Assert.assertEquals(0, controller.getReferenceSpeed());

		user.overrideJoystickPosition(6);
		controller.followSpeed();
		Assert.assertEquals(6, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(12, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(15, controller.getReferenceSpeed());

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
	public void OverridingJoystickPositionToZero_CheckTrainCoasting() {
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		user.overrideJoystickPosition(0);
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}

	@Test
	public void TachographTest() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		Assert.assertTrue(!tachograph.getTachoTable().isEmpty());
	}



}
