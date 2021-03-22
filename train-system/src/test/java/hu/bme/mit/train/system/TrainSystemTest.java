package hu.bme.mit.train.system;

import hu.bme.mit.train.interfaces.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.system.TrainSystem;

import java.util.Date;
import java.util.Timer;

public class TrainSystemTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	TrainTachograph tachograph;
	TrainRunner runner;
	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
		tachograph = system.getTachograph();
		runner = system.getRunner();

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
	public void OverrideSpeedLimitToNegative_SetsSpeedLimitToZero(){
		sensor.overrideSpeedLimit(-5);
		Assert.assertEquals(0, controller.getSpeedLimit());
		Assert.assertNotEquals(-5, controller.getSpeedLimit());
	}

	@Test
	public void OverrideSpeedLimitToNegative_SetsSpeedLimitToZero_2(){
		sensor.overrideSpeedLimit(-5);
		Assert.assertEquals(0, controller.getSpeedLimit());
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
	public void LogDataToTachograph(){
		Assert.assertTrue(tachograph.isEmpty());
		tachograph.recordData();
		Assert.assertFalse(tachograph.isEmpty());
		Assert.assertEquals(tachograph.getData(), 1);
		user.overrideJoystickPosition(5);
		sensor.overrideSpeedLimit(10);
		tachograph.recordData();
		Assert.assertFalse(tachograph.isEmpty());
		user.overrideJoystickPosition(3);
		sensor.overrideSpeedLimit(5);
		tachograph.recordData();

		Assert.assertEquals(tachograph.getData(), 3);
	}

	@Test
	public void TestRunner() throws InterruptedException{
		Assert.assertEquals(0,controller.getReferenceSpeed());
		user.overrideJoystickPosition(1);
		runner.schedule(1000);
		Thread.sleep(2000);
		Assert.assertEquals(2, controller.getReferenceSpeed());
		Thread.sleep(2000);
		Assert.assertEquals(4, controller.getReferenceSpeed());

	}

	@Test
	public void TestExpectedBehaviour() throws InterruptedException{
		//t0
		Assert.assertEquals(0,controller.getReferenceSpeed());
		Assert.assertEquals(0, user.getJoystickPosition());


		// t1-t3
		user.overrideJoystickPosition(1);
		controller.setSpeedLimit(2);
		runner.schedule(1000);
		Thread.sleep(1000);
		Assert.assertEquals(1, controller.getReferenceSpeed());
		Thread.sleep(1000);
		Assert.assertEquals(2, controller.getReferenceSpeed());
		Thread.sleep(1000);
		Assert.assertEquals(2, controller.getReferenceSpeed());

		// t4-t5
		user.overrideJoystickPosition(0);
		Thread.sleep(1000);
		Assert.assertEquals(2, controller.getReferenceSpeed());
		Thread.sleep(1000);
		Assert.assertEquals(2, controller.getReferenceSpeed());

		// t6
		user.overrideJoystickPosition(-1);
		Thread.sleep(1000);
		Assert.assertEquals(1, controller.getReferenceSpeed());

		// t7
		user.overrideJoystickPosition(0);
		Thread.sleep(1000);
		Assert.assertEquals(1, controller.getReferenceSpeed());

		// t8
		Thread.sleep(1000);
		Assert.assertEquals(1, controller.getReferenceSpeed());

	}
}
