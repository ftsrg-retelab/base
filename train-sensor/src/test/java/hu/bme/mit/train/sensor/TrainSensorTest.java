package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class TrainSensorTest {

    private TrainController controller = new TrainControllerImpl();
    private TrainUser user;
    private int speedLimit = 5;
    private boolean danger = false;
    TrainSensor sensor = new TrainSensorImpl(controller, user);

    @Before
    public void before() {

        speedLimit = 5;
        danger = false;
    }

    @Test
    public void DangerousSituation() {
        danger = true;
        sensor.dangerDetection(danger);

    }
}
