package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorTest {

    private TrainSensorImpl trainSensor;
    private TrainController mockController;
    private TrainUser mockUser;

    @Before
    public void before() {
        mockController = Mockito.mock(TrainController.class);
        mockUser = Mockito.mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockController, mockUser);
    }

    @Test
    public void testOverrideSpeedLimitUnderAbsoluteMargin() {
        trainSensor.overrideSpeedLimit(-1);
        Mockito.verify(mockUser).setAlarmState(true);
    }

    @Test
    public void testOverrideSpeedLimitOverAbsoluteMargin() {
        trainSensor.overrideSpeedLimit(501);
        Mockito.verify(mockUser).setAlarmState(true);
    }

    @Test
    public void testOverrideSpeedLimitUnderRelativeMargin() {
        trainSensor.overrideSpeedLimit(150);
        trainSensor.overrideSpeedLimit(50);
        Mockito.verify(mockUser).setAlarmState(true);
    }

    @Test
    public void testOverrideSpeedLimitWithinLimits() {
        Mockito.when(mockController.getReferenceSpeed()).thenReturn(100);
        trainSensor.overrideSpeedLimit(60);
        Mockito.verify(mockUser).setAlarmState(false);
    }
}
