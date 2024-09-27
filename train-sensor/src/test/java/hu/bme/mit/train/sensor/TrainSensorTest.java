package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainSensor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl tsi;

    @Before
    public void before() {
        tsi = new TrainSensorImpl(null, null);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        assertEquals(tsi.getSpeedLimit(), 5);
    }
}
