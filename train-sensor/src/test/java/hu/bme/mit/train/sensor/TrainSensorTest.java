package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainUser user;
    TrainSensor sensor;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void TestOverrideSpeedLimitAbsoluteMarginForNull() {
        sensor.overrideSpeedLimit(0);
        verify(user, times(0)).setAlarmState(true);
    }

    @Test
    public void TestOverrideSpeedLimitAbsoluteMarginForTrue() {
        sensor.overrideSpeedLimit(501);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void TestOverrideSpeedLimitRelativeMarginForTrue() {
        when(controller.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(50);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void TestOverrideSpeedLimitRelativeMarginForFalse() {
        when(controller.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(100);
        verify(user, times(0)).setAlarmState(true);
    }

}
