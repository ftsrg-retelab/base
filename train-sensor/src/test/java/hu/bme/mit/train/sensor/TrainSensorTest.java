package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainSensor sensor;
    TrainUser user;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller,user);
    }

    @Test
    public void CheckInitialSpeedLimit() {
        Assert.assertEquals(5,sensor.getSpeedLimit());
    }

    @Test
    public void OverridingSpeedLimitNormal() {
        sensor.overrideSpeedLimit(10);
        Assert.assertEquals(10,sensor.getSpeedLimit());
        Assert.assertFalse(user.getAlarmState());
    }

    @Test
    public void OverridingSpeedLimitOutOfBounds() {
        sensor.overrideSpeedLimit(-10);
        Assert.assertEquals(-10,sensor.getSpeedLimit());
        when(user.getAlarmState()).thenReturn(true);
        Assert.assertTrue(user.getAlarmState());
    }

    @Test
    public void OverridingSpeedLimitHalfSpeedCriteria() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller,user);

        sensor.overrideSpeedLimit(150);
        sensor.overrideSpeedLimit(50);
        Assert.assertEquals(50,sensor.getSpeedLimit());
        when(user.getAlarmState()).thenReturn(true);
        Assert.assertTrue(user.getAlarmState());
    }
}
