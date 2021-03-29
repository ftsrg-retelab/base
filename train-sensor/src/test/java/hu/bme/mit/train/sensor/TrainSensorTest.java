package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    public void NormalWorkingTest(){
        when(user.getAlarmState()).thenReturn(false);
        sensor.overrideSpeedLimit(60);

        assertEquals(60, sensor.getSpeedLimit());
        verify(controller).setSpeedLimit(60);

        verify(user, times(2)).setAlarmState(false);
    }

    @Test
    public void EdgeCases1Test(){
        when(user.getAlarmState()).thenReturn(true);

        sensor.overrideSpeedLimit(501);

        verify(user).setAlarmState(true);
        verify(controller, Mockito.never()).setSpeedLimit(501);

        assertNotEquals(501, sensor.getSpeedLimit());
    }

    @Test
    public void EdgeCases2Test() {
        when(user.getAlarmState()).thenReturn(true);

        sensor.overrideSpeedLimit(-1);

        verify(user).setAlarmState(true);
        verify(controller, Mockito.never()).setSpeedLimit(-1);

        assertNotEquals(-1, sensor.getSpeedLimit());
    }

    @Test
    public void RelativeMargin1Test() {
        when(user.getAlarmState()).thenReturn(false);
        when(controller.getReferenceSpeed()).thenReturn(75);
        sensor.overrideSpeedLimit(100);

        verify(user, Mockito.times(2)).setAlarmState(false);
        verify(controller).setSpeedLimit(100);

        assertEquals(100, sensor.getSpeedLimit());
    }

    @Test
    public void RelativeMargin2Test() {
        when(user.getAlarmState()).thenReturn(false);
        when(controller.getReferenceSpeed()).thenReturn(75);
        InOrder inOrder = inOrder(user);

        sensor.overrideSpeedLimit(30);

        inOrder.verify(user).setAlarmState(false);
        inOrder.verify(user).setAlarmState(true);
    }
}
