package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void tachographTest(){
        sensor TrainSensorImpl = new TrainSensorImpl(null, null);
        sensor.addToTachograph(1, 1, 1);
        Assert.assertEquals(sensor.tachograph.size(), 1);
    }
}
