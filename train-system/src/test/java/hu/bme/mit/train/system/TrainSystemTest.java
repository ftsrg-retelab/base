package hu.bme.mit.train.system;

import static org.mockito.ArgumentMatchers.contains;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.jacoco.agent.rt.internal_3570298.core.internal.ContentTypeDetector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.HashBasedTable;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

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
	public void Emergency_Break(){
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		controller.setEm_Break(true);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

	@Test
	public void TachgraphTest(){
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		String date = Calendar.getInstance().getTime().toString();
		sensor.setTachograph(date, user.getJoystickPosition(), controller.getReferenceSpeed());
		HashBasedTable table = sensor.getTachograph();
		Collection c = table.values();
		String t = (String)new ArrayList(c).get(0);
		int jp = (int)new ArrayList(c).get(1);
		int rs = (int)new ArrayList(c).get(2);
		Assert.assertEquals(t, date);
		Assert.assertEquals(jp, user.getJoystickPosition());
		Assert.assertEquals(rs, controller.getReferenceSpeed());
	}

	
}
