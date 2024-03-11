package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void tickTest() {
        
        TrainSensorImpl sensor = new TrainSensorImpl(null, null);
        sensor.tick("13:30", 3, 8);
        assertEquals(1,sensor.getTachSize());
    }
}
