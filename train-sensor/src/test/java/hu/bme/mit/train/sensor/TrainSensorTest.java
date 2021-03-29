package hu.bme.mit.train.sensor;

import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.interfaces.TrainUser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
   TrainUser user;
    TrainController cont;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        user = mock(TrainUser.class);
        cont = mock(TrainnController.class);
        trainSensor = new TrainSensorImpl(cont, user);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void JUnitTest() {
       Assert.assertEquals(0,0);
    }

    @Test
    public void OverloadSpeed() {
        trainSensor.overrideSpeedLimit(speedlimit: 510);
        verify(user, times(wantedNumberOfInvocations: 1)).setAlarmState(true);
    }

    @Test
    public void minSpeed() {
        trainSensor.overrideSpeedLimit(speedlimit: -10);
        verify(user, times(wantedNumberOfInvocations: 1)).setAlarmState(true);
    }

    @Test
    public void validSpeed() {
        trainSensor.overrideSpeedLimit(speedlimit: 200);
        verify(user, times(wantedNumberOfInvocations: 0)).setAlarmState(false);
    }

    @Test
    public void marginTest() {
        trainSensor.overrideSpeedLimit(speedlimit: 10);
        verify(user, times(wantedNumberOfInvocations: 1)).setAlarmState(true);
    }
}
