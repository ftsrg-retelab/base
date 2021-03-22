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

    TrainController controller;
    TrainUser user;
    TrainSensor sensor;

    @Before
    public void before() {
        controller = new TrainControllerImpl();
        user = new TrainUserImpl(controller);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void TestSpeedOverride() {
        sensor.overrideSpeedLimit(33);
        Assert.assertEquals(33, sensor.getSpeedLimit());
    }

    @Test
    public void TestOverrideSpeedLimitAbsoluteMarginForNull() {
        sensor.overrideSpeedLimit(0);
        Assert.assertFalse(user.getAlarmState());
    }

    @Test
    public void TestOverrideSpeedLimitAbsoluteMarginForTrue() {
        sensor.overrideSpeedLimit(501);
        Assert.assertTrue(user.getAlarmState());
    }

    @Test
    public void TestOverrideSpeedLimitRelativeMarginForTrue() {
        controller.setSpeedLimit(150);
        user.overrideJoystickPosition(150);
        controller.followSpeed();

        sensor.overrideSpeedLimit(50);
        Assert.assertTrue(user.getAlarmState());
    }

    @Test
    public void TestOverrideSpeedLimitRelativeMarginForFalse() {
        controller.setSpeedLimit(150);
        user.overrideJoystickPosition(150);
        controller.followSpeed();

        sensor.overrideSpeedLimit(100);
        Assert.assertFalse(user.getAlarmState());
    }
}
