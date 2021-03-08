package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

import com.google.common.collect;
import com.google.guava;

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
	public void CheckJostickAndSpeedLimitInitializationCheck() {
		TrainSystem _system = new TrainSystem();
		TrainController _controller = _system.getController();
		TrainUser _user = _system.getUser();
		
		_controller.followSpeed();
		Assert.assertEquals(0, _controller.getReferenceSpeed());
		_user.overrideJoystickPosition(10);
		_controller.followSpeed();
		Assert.assertEquals(0, _controller.getReferenceSpeed());
	}

	@Test
	public void TachographTest() {
		TrainSystem _system = new TrainSystem();
		TrainController _controller = _system.getController();
		TrainUser _user = _system.getUser();
		int currentTime = 0;
		Table<Integer, Integer, Integer> tachograph = HashBasedTable.create();
		
		_user.overrideJoystickPosition(0);
		_controller.followSpeed();
		++currentTime;
		Table.put(currentTime,_user.getJoystickPosition(),_controller.getReferenceSpeed());
		_user.overrideJoystickPosition(10);
		_controller.followSpeed();
		++currentTime;
		Table.put(currentTime,_user.getJoystickPosition(),_controller.getReferenceSpeed());
		Assert.assertTrue(tachograph.containsColumn(1));
	}
	
}
