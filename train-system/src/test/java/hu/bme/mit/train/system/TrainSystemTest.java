package hu.bme.mit.train.system;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainTaco;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TrainSystemTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	TrainTaco tachog;
    TrainSystem system;
	
	@Before
	public void before() {
		system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
		tachog = system.getTacho();


		sensor.overrideSpeedLimit(50);
        Date date = new Date();
		system.addToTable(0, 0, date);
	}
	
	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
	    int lim = 10;
	    int pos = 5;
        Date date = new Date();
		sensor.overrideSpeedLimit(lim);
        system.addToTable(0, lim, date);

		Assert.assertEquals(0, controller.getReferenceSpeed());

		user.overrideJoystickPosition(pos);
        date = new Date();
        system.addToTable(pos, lim, date);

		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}

	@Test
	public void testingCorrectSpeedIncrease() {
        int lim = 20;
        int pos = 5;
        Date date = new Date();
		sensor.overrideSpeedLimit(lim);
        system.addToTable(pos, lim, date);
		Assert.assertEquals(0, controller.getReferenceSpeed());

		user.overrideJoystickPosition(pos);
        date = new Date();
        system.addToTable(pos, lim, date);
		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(15, controller.getReferenceSpeed());
	}

	@Test
	public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
	    int lim = 0;
	    int pos = 4;
	    Date date = new Date();
		user.overrideJoystickPosition(pos);
        system.addToTable(pos, lim, date);
		controller.followSpeed();
		pos = -5;
		user.overrideJoystickPosition(pos);
        date = new Date();
        system.addToTable(pos, lim, date);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

	@Test
	public void checkCollection() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

    @Test
    public void checkGuavaTable() {
        int countOfGuava = system.getGuavaTable().size();
        Assert.assertTrue(countOfGuava > 0);

    }

}
