package hu.bme.mit.train.sensor;

import hu.bme.mit.train.clock.TrainClockTimer;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.tachograph.TrainTachograph;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockedTrainController;
    TrainSensor sensor;
    TrainUser mockedTrainUser;
    TrainTachograph tachograph;

    @Before
    public void before() {
        mockedTrainController = mock(TrainController.class);
        mockedTrainUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockedTrainController, mockedTrainUser);
    }

    @Test
    public void GoingUnderAbsoluteLimit() {
        sensor.overrideSpeedLimit(-50);
        Mockito.verify(mockedTrainUser, times(1)).setAlarmState(true);

    }

    @Test
    public void GoingOverAbsoluteLimit() {
        sensor.overrideSpeedLimit(501);
        Mockito.verify(mockedTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void SetLimitToLessThanHalf() {
        sensor.overrideSpeedLimit(500);
        when(mockedTrainController.getReferenceSpeed()).thenReturn(400);
        sensor.overrideSpeedLimit(50);
    }

    @Test
    public void AlarmDoesNotTrigger() {
        sensor.overrideSpeedLimit(500);
        sensor.overrideSpeedLimit(0);
        when(mockedTrainController.getReferenceSpeed()).thenReturn(300);
        sensor.overrideSpeedLimit(100);
        Mockito.verify(mockedTrainUser, never()).setAlarmState(true);
    }
}
