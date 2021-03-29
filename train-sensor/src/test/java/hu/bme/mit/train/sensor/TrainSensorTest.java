package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TransferQueue;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    public TrainController controller;
    public TrainUser user;
    public TrainSensorImpl sensor;


    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void testAbsoluteLowLimit() {
        sensor.overrideSpeedLimit(-1);
        verify(controller, times(1)).getReferenceSpeed();
        verify(user, times(1)).setAlarmState(true);
    }
    @Test
    public void testAbsoluteHighLimit() {
        sensor.overrideSpeedLimit(501);
        verify(controller, times(1)).getReferenceSpeed();
        verify(user, times(1)).setAlarmState(true);
    }
    @Test
    public void testRelativeLowSpeedLimit() {
        when(controller.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(30);
        verify(controller, times(1)).getReferenceSpeed();
        verify(user, times(1)).setAlarmState(true);
    }
    @Test
    public void testEdgeCasesForAbsoluteLimit() {
        sensor.overrideSpeedLimit(500);
        sensor.overrideSpeedLimit(0);
        verify(controller, times(2)).getReferenceSpeed();
        verify(user, times(2)).setAlarmState(false);
    }
}
