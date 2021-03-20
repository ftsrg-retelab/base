package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainUserImpl mockTrainUserImpl;
    TrainControllerImpl mockTrainControllerImpl;
    TrainSensorImpl sensor;
    TrainControllerImpl trainControllerimpl;


    @Before
    public void beforeTests() {

        mockTrainUserImpl=mock(TrainUserImpl.class);
        trainControllerimpl=new TrainControllerImpl();
        trainControllerimpl.setSpeedLimit(50);
        trainControllerimpl.setJoystickPosition(50);
        trainControllerimpl.followSpeed();

        sensor=new TrainSensorImpl(trainControllerimpl,mockTrainUserImpl);
        // TODO Add initializations
    }

    @Test
    public void AlarmStateTrueTest() {
    	//TrainSensorImpl a= new TrainSensorImpl(null, null);
    	//assertSame(5,a.getSpeedLimit());

        // TODO Delete this and add test cases based on the issues
        when(mockTrainUserImpl.getAlarmState()).thenReturn(false);
        sensor.overrideSpeedLimit(40);
        verify(mockTrainUserImpl, times(1)).setAlarmState(false);


    }


    @Test
    public void SpeedBelowZeroTest() {
        when(mockTrainUserImpl.getAlarmState()).thenReturn(true);
        sensor.overrideSpeedLimit(-1);
        verify(mockTrainUserImpl, times(1)).setAlarmState(true);
    }



    @Test
    public void SpeedOver500Test() {
        when(mockTrainUserImpl.getAlarmState()).thenReturn(true);
        sensor.overrideSpeedLimit(501);
        verify(mockTrainUserImpl, times(1)).setAlarmState(true);
    }


    @Test
    public void SpeedHalfLowerThenRefTest() {

        when(mockTrainUserImpl.getAlarmState()).thenReturn(true);
        sensor.overrideSpeedLimit(20);
        verify(mockTrainUserImpl, times(1)).setAlarmState(true);

    }
}
