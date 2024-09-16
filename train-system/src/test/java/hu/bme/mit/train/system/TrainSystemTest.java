package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
	public void TestOverrideSpeedLimit() {
		int testSpeedLimit = 333;
		sensor.overrideSpeedLimit(testSpeedLimit);
		Assert.assertEquals(sensor.getSpeedLimit(), testSpeedLimit);
	}

	@Test
	public void TestExpectedBehaviour() {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				/*System.out.println("Joystick position?");
				Scanner scanner = new Scanner(System.in);
				int joystickPosition = scanner.nextInt();*/
				int joystickPosition = 5;
				user.overrideJoystickPosition(joystickPosition);
				controller.followSpeed();
				Assert.assertEquals(5, controller.getReferenceSpeed());
			}
		};
		long delay = 1000L;
		Timer timer = new Timer("Timer");
		timer.schedule(timerTask, delay);
	}
	
}
