package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;
import com.google.guava.*;
import java.util.Map;
import java.util.Set;

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
	public void EngageEmergencyBreak() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		controller.emergencyBreak();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

	@Test
	public void TachografEntries() {
		sensor.overrideSpeedLimit(10);
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		controller.followSpeed();
		controller.followSpeed();
		sensor.overrideSpeedLimit(10);
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		controller.followSpeed();
		controller.followSpeed();
		sensor.overrideSpeedLimit(10);
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		controller.followSpeed();
		controller.followSpeed();

		int cnt = 0;

		for(Map.Entry<LocalDateTime ,int, int> entry : sensor.getTachografRecording().entrySet()) {
			cnt++;
		 }

		Assert.assertNotEquals(0, cnt);
	}

	
}
