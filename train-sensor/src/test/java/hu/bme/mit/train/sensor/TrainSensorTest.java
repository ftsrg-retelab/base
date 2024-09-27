package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl trainSensor;

    private TrainUser mockUser;
    private TrainController mockController;
    private TrainSensor sensor;

    @Before
    public void before() {
        TrainController controller = new TrainControllerImpl();
        TrainUser user = new TrainUserImpl(controller);
        trainSensor = new TrainSensorImpl(controller, user);

        mockUser = mock(TrainUser.class);
        mockController = mock(TrainController.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
        when(mockController.getReferenceSpeed()).thenReturn(200);
    }

    @Test
    public void OverrideSpeedLimit_SetSpeedLimitToNegative() {
        trainSensor.overrideSpeedLimit(-1);
        Assert.assertEquals(-1, trainSensor.getSpeedLimit());
    }

    @Test
    public void OverrideSpeedLimitMoreThenFiveHundred() {
        sensor.overrideSpeedLimit(1000);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverrideSpeedLimitUnderZero() {
        sensor.overrideSpeedLimit(-42);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverrideSpeedLimitLessThenHalf() {
        sensor.overrideSpeedLimit(42);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverrideSpeedLimitWithNormalValue() {
        sensor.overrideSpeedLimit(250);
        verify(mockUser, times(0)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }
}
