package hu.bme.mit.train.sensor;


import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class TrainSensorTest {

    TrainController mockController;
    TrainSensorImpl mockSensor;
    TrainUser mockUser;

    @Before
    public void before() {
        mockUser = mock(TrainUser.class);

        mockController = mock(TrainController.class);
        mockSensor = new TrainSensorImpl(mockController, mockUser);
        System.out.println(mockSensor.getSpeedLimit());
    }

    @Test
    public void overrideSpeedNegativeValueTest() {
        mockSensor.overrideSpeedLimit(-4);
        Assert.assertFalse(mockUser.getAlarmState());
    }

    @Test
    public void overrideSpeedBorderValueTest() {
        mockSensor.overrideSpeedLimit(0);
        Assert.assertFalse(mockUser.getAlarmState());
        mockSensor.overrideSpeedLimit(500);
        Assert.assertFalse(mockUser.getAlarmState());
    }

    @Test
    public void overrideSpeedMoreThan500ValueTest() {
        mockSensor.overrideSpeedLimit(513);
        Assert.assertFalse(mockUser.getAlarmState());
    }

    @Test
    public void overrideSpeedLessThenHalfMargin() {
        mockController.setSpeedLimit(150);
        mockUser.overrideJoystickPosition(150);
        mockController.followSpeed();

        mockSensor.overrideSpeedLimit(100);
        Assert.assertFalse(mockUser.getAlarmState());
    }
    @Test
    public void overrideSpeedMoreThenHalfMargin() {
        mockController.setSpeedLimit(150);
        mockUser.overrideJoystickPosition(150);
        mockController.followSpeed();

        mockSensor.overrideSpeedLimit(4);
        Assert.assertFalse(mockUser.getAlarmState());
    }


    @Test
    public void excercise4DOT7Test() {
        int a = 2;
        int b = -2;
        int res = a + b;
        Assert.assertEquals(0, res);
    }


}
