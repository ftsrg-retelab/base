package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainSensorTest {

    private TrainSensorImpl tsi;


    @Before
    public void before() {

        TrainControllerImpl tc = new TrainControllerImpl();
        tsi = new TrainSensorImpl(tc, new TrainUserImpl(tc));
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        Assert.assertEquals(5, tsi.getSpeedLimit());

    }
}