package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl sensor;

    @Before
    public void before() {
        sensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void checkDefaultSpeedLimit() {
        Assert.assertEquals(8, sensor.getSpeedLimit());
    }
}
