package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController controller;
    TrainSensor sensor;
    TrainUser user;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        sensor = mock(TrainSensorImpl.class);
        user = mock(TrainUserImpl.class);
    }

    @Test
    public void Test1() {
        controller.setSpeedLimit(-1);
        when(user.getAlarmState()).thenReturn(true);
    }

    @Test
    public void Test2() {
        controller.setSpeedLimit(1);
        verify(user, times(0)).setAlarmState(true);
    }

    @Test
    public void Test3() {
        controller.setSpeedLimit(501);
        controller.setSpeedLimit(1);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void Test4() {
        controller.setSpeedLimit(0);
        controller.setSpeedLimit(1);
        verify(user, times(1)).setAlarmState(true);
    }
}
