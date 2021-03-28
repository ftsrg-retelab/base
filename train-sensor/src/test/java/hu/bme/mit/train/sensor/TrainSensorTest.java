package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class TrainSensorTest {
     TrainSensor ts;
     TrainUser tu;
     TrainController tc;

    @Before
    public void before(){

        tc = mock(TrainController.class);
        tu = mock(TrainUser.class);
        ts = new TrainSensorImpl(tc, tu);
        when(tc.getReferenceSpeed()).thenReturn(50);
    }

    @Test
    public void overrideSpeedLimit_lessThan0SpeedLimit_triggerAlarm(){
        ts.overrideSpeedLimit(-5);
        Assert.assertEquals(ts.getSpeedLimit(), -5);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(1)).setAlarmState(true);
    }

    @Test
    public void overrideSpeedLimit_moreThan500SpeedLimit_triggerAlarm(){
        ts.overrideSpeedLimit(501);
        Assert.assertEquals(ts.getSpeedLimit(), 501);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(1)).setAlarmState(true);
    }

    @Test
    public void overrideSpeedLimit_lessThanHalfRefSpeed_triggerAlarm(){
        ts.overrideSpeedLimit(10);
        Assert.assertEquals(ts.getSpeedLimit(), 10);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(1)).setAlarmState(true);
    }

    @Test
    public void overrideSpeedLimit_valueOK_noAlarm(){
        ts.overrideSpeedLimit(40);
        Assert.assertEquals(ts.getSpeedLimit(), 40);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(0)).setAlarmState(true);

    }
}
