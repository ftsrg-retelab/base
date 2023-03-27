package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainUser user;
    TrainSensorImpl sensor;
    TrainController controller;

    @Before
    public void before() {
        user = mock(TrainUser.class);
        controller = mock(TrainController.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void testSettingSensorValueToLowEdge() {
        sensor.overrideSpeedLimit(0);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void testSettingSensorValueToHighEdge() {
        sensor.overrideSpeedLimit(500);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void testSettingSensorValueBetweenEdges() {
        sensor.overrideSpeedLimit(100);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void testSpeedLimitLessThanAbsoluteMinimum() {
        sensor.overrideSpeedLimit(-1);
        verify(user, times(2)).setAlarmState(true);
    }

    @Test
    public void testSpeedLimitMoreThanAbsoluteMaximum() {
        sensor.overrideSpeedLimit(501);
        verify(user, times(2)).setAlarmState(true);
    }
}
