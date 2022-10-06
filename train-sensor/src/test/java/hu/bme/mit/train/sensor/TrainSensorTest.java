package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
    	
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {
    	TrainSensorImpl a= new TrainSensorImpl(null, null);
    	assertSame(5,a.getSpeedLimit());
        // TODO Delete this and add test cases based on the issues
    }
}
