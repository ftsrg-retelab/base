package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        private TrainController controller;
        private TrainUser user;
        TrainSensorImpl tsi = new TrainSensorImpl(controller, user);
    }

    @Test
    public void TestSpeedLimit() {
        AssertEquals(tsi.getSpeedLimit(),4+1);
    }
}
