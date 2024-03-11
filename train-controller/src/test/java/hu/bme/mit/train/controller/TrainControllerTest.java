package hu.bme.mit.train.controller;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainControllerTest {
    @Test
    public void TesztVeszfek() {
        TrainControllerImpl trainController = new TrainControllerImpl();
        trainController.setJoystickPosition(4); //legyen valami valid speed
        trainController.setJoystickPosition(-10); 
        assertEquals(0, trainController.getReferenceSpeed());
    }

    public void TesztSetSpeedlimit()
    {
        TrainControllerImpl trainController = new TrainControllerImpl();
        trainController.setSpeedLimit(15);
        assertEquals(15,trainController.getSpeedLimit());
    }
}
