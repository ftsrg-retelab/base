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
		try {
			sensor.overrideSpeedLimit(10);
			Thread.sleep(100);
			Assert.assertEquals(0, controller.getReferenceSpeed());
			Thread.sleep(100);
			user.overrideJoystickPosition(5);
			Thread.sleep(100);
			Assert.assertEquals(5, controller.getReferenceSpeed());
			Thread.sleep(100);
			Assert.assertEquals(10, controller.getReferenceSpeed());
			Thread.sleep(100);
			Assert.assertEquals(10, controller.getReferenceSpeed());
		}
		catch (Exception ignored) {}
	}

	@Test
	public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
		try {
			Thread.sleep(100);
			user.overrideJoystickPosition(4);
			Thread.sleep(100);
			user.overrideJoystickPosition(-5);
			Thread.sleep(100);
			Assert.assertEquals(0, controller.getReferenceSpeed());
		}
		catch (Exception ignored) {}
	}
	
	@Test
	public void OverridingJoystickPositionToZero_CheckTrainCoasting() {
		try{
			user.overrideJoystickPosition(0);
			user.overrideJoystickPosition(5);
			Thread.sleep(100);
			Assert.assertEquals(5, controller.getReferenceSpeed());
			Thread.sleep(100);
			Assert.assertEquals(10, controller.getReferenceSpeed());
			user.overrideJoystickPosition(0);
			Thread.sleep(100);
			Assert.assertEquals(10, controller.getReferenceSpeed());
			Thread.sleep(100);
			Assert.assertEquals(10, controller.getReferenceSpeed());
		}
		catch (Exception ignored) {}
	}

	@Test
	public void TachographTest() {
		try {
			Thread.sleep(100);
			user.overrideJoystickPosition(4);
			Thread.sleep(100);
			user.overrideJoystickPosition(-5);
			Thread.sleep(100);
			Assert.assertTrue(!tachograph.getTachoTable().isEmpty());
		}
		catch (Exception ignored) {}
	}


	@Test
	public void NewAccelerationTest(){
		try {
			sensor.overrideSpeedLimit(100);
			user.overrideJoystickPosition(5);
			Thread.sleep(1000);
			user.overrideJoystickPosition(0);
			Thread.sleep(100);
			Assert.assertEquals(55, controller.getReferenceSpeed());

		}
		catch (Exception ignored) {}
	}



}
