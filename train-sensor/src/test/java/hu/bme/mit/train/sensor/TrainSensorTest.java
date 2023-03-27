package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	
	@Before
	public void before() {
		controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
	}
    @Test
    public void tachographTest() {
        String date = "2019.11.11. 11:11:11";
        int referenceSpeed = 10;
        int joystickPosition = 1;
        sensor.saveTachograph(date, referenceSpeed, joystickPosition);
        Assert.assertEquals(1, sensor.getTachograph().size());
        Assert.assertEquals(joystickPosition, sensor.getTachograph().get(date, referenceSpeed).intValue());
        
    }
}
