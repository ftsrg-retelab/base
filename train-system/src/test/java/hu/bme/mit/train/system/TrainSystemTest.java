package hu.bme.mit.train.system;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainSystemTest {

    TrainController mController;
    TrainSensor mSensor;
    TrainUser mUser;

    @Before
    public void before() {
        TrainSystem system = new TrainSystem();
        mController = system.getController();
        mSensor = system.getSensor();
        mUser = system.getUser();

        mSensor.overrideSpeedLimit(50);
    }

    @Test
    public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
        mSensor.overrideSpeedLimit(10);

        Assert.assertEquals(0, mController.getReferenceSpeed());

        mUser.overrideJoystickPosition(5);

        mController.followSpeed();
        Assert.assertEquals(5, mController.getReferenceSpeed());
        mController.followSpeed();
        Assert.assertEquals(10, mController.getReferenceSpeed());
        mController.followSpeed();
        Assert.assertEquals(10, mController.getReferenceSpeed());
    }

    @Test
    public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
        mUser.overrideJoystickPosition(4);
        mController.followSpeed();
        muser.overrideJoystickPosition(-5);
        mController.followSpeed();
        Assert.assertEquals(0, mController.getReferenceSpeed());
    }


}
