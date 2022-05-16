package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensor sensor; 
    TrainUser mu; 
    TrainController mc; 
    
    @Before
    public void before() {
        mu = mock(TrainUser.class); 
        mc = mock(TrainController.class); 
        sensor= new TrainSensorImpl(mc, mu);
    }

    @Test
    public void getValueTest() {
        int value = sensor.getSpeedLimit();
        assertEquals(10, value);
    }

    @Test
    public void setNegativeSpeed() {
        doNothing().when(mu).setAlarmState(isA(boolean.class)); 
        sensor.overrideSpeedLimit(-10);

        verify(mu, times(1)).setAlarmState(true);
        verify(mu, times(1)).setAlarmState(false);
    }

    @Test
    public void setNormalSpeed() {
        doNothing().when(mu).setAlarmState(isA(boolean.class)); 
        sensor.overrideSpeedLimit(11);

        verify(mu, times(0)).setAlarmState(true);
        verify(mu, times(1)).setAlarmState(false);
    }

    @Test
    public void setExtremeSpeed() {
        doNothing().when(mu).setAlarmState(isA(boolean.class)); 
        sensor.overrideSpeedLimit(521);

        verify(mu, times(1)).setAlarmState(false);
        verify(mu, times(1)).setAlarmState(true);
    }
}
