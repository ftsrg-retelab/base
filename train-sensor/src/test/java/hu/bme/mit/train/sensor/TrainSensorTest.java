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
        user = mock(TrainUserImpl.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void Test1() {
        sensor.overrideSpeedLimit(-1);
        when(user.getAlarmState()).thenReturn(true);
    }

    @Test
    public void Test2() {
        sensor.overrideSpeedLimit(1);
        when(user.getAlarmState()).thenReturn(false);
    }

    @Test
    public void Test3() {
        controller.setSpeedLimit(501);
        when(user.getAlarmState()).thenReturn(true);
    }

    @Test
    public void Test4() {
        sensor.overrideSpeedLimit(0);
        when(user.getAlarmState()).thenReturn(true);
    }

    @Test
    public void Test5() {
        sensor.overrideSpeedLimit(1);
        when(sensor.getSpeedLimit()).thenReturn(1);
    }
}
