package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl sensor;
    TrainController controller;

    @Before
    public void before() {
        controller = new TrainController() {
            @Override
            public void followSpeed() {}

            @Override
            public int getReferenceSpeed() { return 0; }

            @Override
            public void setSpeedLimit(int speedLimit) {}

            @Override
            public void setJoystickPosition(int joystickPosition) {}
        };
        sensor = new TrainSensorImpl(controller, null);
    }

    @Test
    public void testDefaultSensorValue() {
        assert sensor.getSpeedLimit() == 10;
    }

    @Test
    public void testSettingSensorValue() {
        sensor.overrideSpeedLimit(12);
        assert sensor.getSpeedLimit() == 12;
    }
}
