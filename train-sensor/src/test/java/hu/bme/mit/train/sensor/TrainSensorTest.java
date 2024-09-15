package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainSensorTest {

    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        TrainController controller = new TrainControllerImpl();
        TrainUser user = new TrainUserImpl(controller);
        trainSensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void OverrideSpeedLimit_SetSpeedLimitToNegative() {
        trainSensor.overrideSpeedLimit(-1);
        Assert.assertEquals(-1, trainSensor.getSpeedLimit());
    }
}
