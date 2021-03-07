package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainSensorTest {

    private TrainSensorImpl mSensor;

    @Before
    public void before() {
        mSensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        Assert.assertEquals(5, mSensor.getSpeedLimit());
    }
}
