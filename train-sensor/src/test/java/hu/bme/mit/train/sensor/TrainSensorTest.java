package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController controller;
    TrainSensor sensor;
    TrainUser user;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUserImpl.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void Test1() {
        sensor.overrideSpeedLimit(-1);
        verify(user, times(1)).setAlarmState(true);

    }

    @Test
    public void Test2() {
        sensor.overrideSpeedLimit(1);
        verify(user, times(0)).setAlarmState(true);
    }

    @Test
    public void Test3() {
        sensor.overrideSpeedLimit(501);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void Test4() throws InterruptedException {
        user.overrideJoystickPosition(10);
        wait(10000);
        sensor.overrideSpeedLimit(0);
        when(user.getAlarmState()).thenReturn(true);
    }

    @Test
    public void Test5() {
        sensor.overrideSpeedLimit(0);
        verify(user, times(0)).setAlarmState(true);
    }

    @Test
    public void Test6() {
        sensor.overrideSpeedLimit(0);
        assertEquals(0, sensor.getSpeedLimit());
    }
}
