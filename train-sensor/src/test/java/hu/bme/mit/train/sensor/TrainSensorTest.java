package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    
    TrainController mockC;
    TrainUser mockU;
    
    @Before
    public void before() {
        mockC = mock(TrainController.class);
        mockU = mock(TrainUser.class);
    }


}
