package hu.bme.mit.train.tachograph;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.tachograph.TrainTachograph;
import hu.bme.mit.train.system.TrainSystem;

public class TrainTachographTest {

	TrainTachograph tachograph;
	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
		tachograph = new TrainTachograph(system);
	}
	
	@Test
	public void test() {
		tachograph.record();
		Date now = new Date(System.currentTimeMillis() / 100 * 100);
		int joystickPosition = user.getJoystickPosition();
		int referenceSpeed = controller.getReferenceSpeed();
		assertEquals(tachograph.report(now, joystickPosition), referenceSpeed);
	}
}
