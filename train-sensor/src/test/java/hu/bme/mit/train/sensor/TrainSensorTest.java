package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TrainSensorTest {

    TrainController controller;
    TrainSensor sensor;

    @Before
    public void before() {
        controller=new TrainController() {
            @Override
            public void followSpeed() {

            }

            @Override
            public int getReferenceSpeed() {
                return 0;
            }

            @Override
            public void setSpeedLimit(int speedLimit) {
            }

            @Override
            public void setJoystickPosition(int joystickPosition) {
            }
        };

        sensor=new TrainSensorImpl(controller ,null);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        assertEquals(5, sensor.getSpeedLimit());
    }
}
