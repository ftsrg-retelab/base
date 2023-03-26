package hu.bme.mit.train.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainUserTest {

	TrainUser user;

	@Before
	public void before() {
		user = new TrainUserImpl(null);
	}
	
	@Test
	public void testAlarmFlag() {
		Assert.assertEquals(user.getAlarmFlag(), false);
	}
	
}
