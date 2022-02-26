package test.java.hu.bme.mit.train.system;

import main.java.hu.bme.mit.train.system.Tachograf_Sys;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TachografSysTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	
	@Before
	public void before() {
		Tachograf_Sys system = new Tachograf_Sys();
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
	public void OverridingJoystickPosition_DecreasesReferenceSpeed() {
		sensor.overrideSpeedLimit(5);

		user.overrideJoystickPosition(10);

		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());

		sensor.overrideSpeedLimit(0);

		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

	@Test
	public void SetLimitSpeed_GetLimitSpeed()
	{
		sensor.overrideSpeedLimit(10);
		user.overrideJoystickPosition(10);
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}
}
