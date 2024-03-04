package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;


public class TrainSensorTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;

    @Before
    public void before() {
        sensor = new TrainSensorImpl(controller, user);
    }
}
