package hu.bme.mit.train.system;

import hu.bme.mit.train.tachograph.TrainTachograph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

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
	public void OverridingJoystickPosition_SetReferenceSpeedToZeroThanIncrease() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());

		sensor.overrideSpeedLimit(30);

		Assert.assertEquals(0, controller.getReferenceSpeed());

		user.overrideJoystickPosition(10);
		Assert.assertEquals(0, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(20, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(30, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(30, controller.getReferenceSpeed());
	}

	@Test
	public void OverridingJoystickPosition_CheckIfTachographHasElements() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		tachograph.addRecord(user.getJoystickPosition(), controller.getReferenceSpeed());
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		tachograph.addRecord(user.getJoystickPosition(), controller.getReferenceSpeed());
		Assert.assertEquals(0, controller.getReferenceSpeed());

		sensor.overrideSpeedLimit(30);

		Assert.assertEquals(0, controller.getReferenceSpeed());

		user.overrideJoystickPosition(10);
		Assert.assertEquals(0, controller.getReferenceSpeed());
		controller.followSpeed();
		tachograph.addRecord(user.getJoystickPosition(), controller.getReferenceSpeed());
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		tachograph.addRecord(user.getJoystickPosition(), controller.getReferenceSpeed());
		Assert.assertEquals(20, controller.getReferenceSpeed());
		controller.followSpeed();
		tachograph.addRecord(user.getJoystickPosition(), controller.getReferenceSpeed());
		Assert.assertEquals(30, controller.getReferenceSpeed());
		controller.followSpeed();
		tachograph.addRecord(user.getJoystickPosition(), controller.getReferenceSpeed());
		Assert.assertEquals(30, controller.getReferenceSpeed());

		Assert.assertEquals(6, tachograph.getSize());
	}
}
