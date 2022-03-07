package hu.bme.mit.train.tachnograph;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

public class TachnographTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
	}
	
	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
		sensor.overrideSpeedLimit(50);
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		Tachnograph.addData(user.getJoystickPosition(), controller.getReferenceSpeed());
        Assert.assertTrue(Tachnograph.hasData());
	}
	
}
