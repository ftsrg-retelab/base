package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class TrainSensorTest {

    private TrainSensor ts;
    private TrainUser tu;
    private TrainController tc;

    @Before
    public void before() throws InterruptedException {

        tc = mock(TrainController.class);
        tu = mock(TrainUser.class);
        ts = new TrainSensorImpl(tc, tu);
        tc.setSpeedLimit(50);
        tc.setJoystickPosition(25);
        //waiting for reference speed adjustment
        Thread.sleep(3000);
    }


    @Test
    public void overrideSpeedLimit_lessThan0SpeedLimit_triggerAlarm(){
        ts.overrideSpeedLimit(-5);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(1)).setAlarmState(true);
    }

    @Test
    public void overrideSpeedLimit_moreThan500SpeedLimit_triggerAlarm(){
        ts.overrideSpeedLimit(501);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(1)).setAlarmState(true);
    }

    @Test
    public void overrideSpeedLimit_lessThanHalfRefSpeed_triggerAlarm(){
        ts.overrideSpeedLimit(10);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(1)).setAlarmState(true);
    }

    @Test
    public void overrideSpeedLimit_valueOK_noAlarm(){
        ts.overrideSpeedLimit(40);
        when(tu.getAlarmState()).thenReturn(true);
        verify(tu,times(1)).setAlarmState(true);
    }
}
