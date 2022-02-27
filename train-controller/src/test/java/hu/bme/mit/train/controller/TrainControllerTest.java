package hu.bme.mit.train.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerTest {

    @Before
    public void TestController() {
        TrainController traincontroller = new TrainController();
    }
}
