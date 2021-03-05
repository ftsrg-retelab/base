package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainController controller;
    private TrainSensorImpl ts;

    @Before
    public void before() {
        TrainController controller = new TrainControllerImpl();
        ts =  new TrainSensorImpl(controller, new TrainUserImpl(controller));
    }

    @Test
    public void SpeedLimitTest() {
        assertEquals(5, ts.getSpeedLimit());
    }
}
