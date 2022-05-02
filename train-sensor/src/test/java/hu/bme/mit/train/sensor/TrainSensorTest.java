package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainUser user;
    TrainController trainController; 

    @Before
    public void before() {
        trainController = mock(TrainController.class);  
        user = mock(TrainUser.class);
        when(user.getReferenceSpeed()).thenReturn(5);
        when(trainController.getReferenceSpeed).thenReturn(5);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void Test1() {
        user.overrideSpeedLimit(10);
        assertFalse(user.getAlarmState());
    }

    @Test
    public void Test2() {
        user.overrideSpeedLimit(-10);
        assertTrue(user.getAlarmState());
    }

    @Test
    public void Test3() {
        user.overrideSpeedLimit(501);
        assertTrue(user.getAlarmState());
    }

   @Test
    public void Test4() {
        user.overrideSpeedLimit(15);
        assertTrue(user.getAlarmState());
    } 
}
