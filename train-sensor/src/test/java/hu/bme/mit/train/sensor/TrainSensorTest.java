package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        TrainController mockController = mock(TrainController.class);
        TrainUser mockUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockController, mockUser);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        long timestamp = System.currentTimeMillis();
        int joystickPosition = 2;
        int referenceSpeed = 50;
        trainSensor.recordTachographData(timestamp, joystickPosition, referenceSpeed);
        Integer recordedSpeed = trainSensor.tachographData.get(timestamp, joystickPosition);
        Assert.assertEquals(referenceSpeed, recordedSpeed.intValue());
    }
    }
