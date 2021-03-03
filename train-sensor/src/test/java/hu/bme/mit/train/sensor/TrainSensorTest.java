package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        int x = 0;
        for (int i=0; i<5;i++){
            x+=i*2;
        }
        assertEquals(x,20);
    }
}
