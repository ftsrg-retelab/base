package hu.bme.mit.train.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TrainControllerImplTest {
    @Test
    public void followSpeed() {
        TrainControllerImpl controller = new TrainControllerImpl();
        controller.setReferenceSpeed(-1);
        controller.followSpeed();
        assertTrue(controller.getReferenceSpeed() == 0);
    }
}