package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainSensor sensor;

    @Before
    public void before() {
        sensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void TachographRecordCreated() {
        sensor.recordTachograph(4, 5);
        Assert.assertFalse(sensor.readTachograph().isEmpty());
    }
}
