package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
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
        controller=mock(TrainController.class);
        user=mock(TrainUser.class);

        sensor=new TrainSensorImpl(controller ,user);

        when(controller.getReferenceSpeed()).thenReturn(5);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        assertEquals(5, sensor.getSpeedLimit());
    }

    @Test
    public void speedLimitDecreasesMoreThan50Pct() {
        sensor.overrideSpeedLimit(1);
        verify(user,times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitLessThanZero(){
        sensor.overrideSpeedLimit(-20);
        verify(user,times(2)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitMoreThan500(){
        sensor.overrideSpeedLimit(503);
        verify(user,times(1)).setAlarmState(true);
    }

    @Test
    public void isAlarmTrue(){
        sensor.overrideSpeedLimit(500);
        when(user.getAlarmState()).thenReturn(true);
    }


}
