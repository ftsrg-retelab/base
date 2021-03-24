package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

import java.util.Timer;
import java.util.TimerTask;

public class TrainSystemTest {

    TrainController controller;
    TrainSensor sensor;
    TrainUser user;

    @Before
    public void before() {
        TrainSystem system = new TrainSystem();
        controller = system.getController();
        sensor = system.getSensor();
        user = system.getUser();

        sensor.overrideSpeedLimit(50);
    }

    @Test
    public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
        sensor.overrideSpeedLimit(10);

        Assert.assertEquals(0, controller.getReferenceSpeed());

        user.overrideJoystickPosition(5);

        controller.followSpeed();
        Assert.assertEquals(5, controller.getReferenceSpeed());
        controller.followSpeed();
        Assert.assertEquals(10, controller.getReferenceSpeed());
        controller.followSpeed();
        Assert.assertEquals(10, controller.getReferenceSpeed());
    }

    @Test
    public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
        user.overrideJoystickPosition(4);
        controller.followSpeed();
        user.overrideJoystickPosition(-5);
        controller.followSpeed();
        Assert.assertEquals(0, controller.getReferenceSpeed());
    }

    @Test
    public void UserChangesJoystickPositionTest() {
        TimerTask timerTaskAccelerate = new TimerTask() {
            @Override
            public void run() {
                user.overrideJoystickPosition(3);
                Assert.assertEquals(3, controller.getReferenceSpeed());
            }
        };

        TimerTask timerTaskDecelerate = new TimerTask() {
            @Override
            public void run() {
                user.overrideJoystickPosition(5);
                Assert.assertEquals(5, controller.getReferenceSpeed());
                user.overrideJoystickPosition(-1);
                Assert.assertEquals(4, controller.getReferenceSpeed());
            }
        };
        TimerTask timerTaskHold = new TimerTask() {
            @Override
            public void run() {
                user.overrideJoystickPosition(4);
                Assert.assertEquals(4, controller.getReferenceSpeed());
                user.overrideJoystickPosition(0);
                Assert.assertEquals(4, controller.getReferenceSpeed());
            }
        };
        long delay = 100L;
        Timer timer = new Timer("Timer");
        timer.schedule(timerTaskAccelerate, delay);
        timer.schedule(timerTaskDecelerate,delay);
        timer.schedule(timerTaskHold,delay);
    }

}
