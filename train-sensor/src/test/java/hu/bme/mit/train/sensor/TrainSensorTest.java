package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
	TrainSensor sensor;
	
	@Before
	public void before() {
		controller = new TrainControllerImpl();
		sensor = new TrainSensorImpl(controller);

		sensor.overrideSpeedLimit(50);
	}

    @Test
    public void ThisIsAnExampleTestStub() {
        sensor.overrideSpeedLimit(30); 
        Assert.assertEquals(30, sensor.getSpeedLimit());

    }

}
