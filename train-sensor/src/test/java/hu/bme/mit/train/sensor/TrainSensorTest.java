package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController trainControllerMock;
    TrainUser trainUserMock;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        trainControllerMock = mock(TrainController.class);
        trainUserMock = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(trainControllerMock, trainUserMock);
    }

    @Test
    public void DoNotRaiseFlagIfValueIsCorrect() {
        trainSensor.overrideSpeedLimit(50);
        verify(trainUserMock, times(0)).setAlarmState(true);
    }

    @Test
    public void RaiseFlagWhenSpeedIsNegative() {
        trainSensor.overrideSpeedLimit(-100);
        verify(trainUserMock, times(1)).setAlarmState(true);
    }

    @Test
    public void RaiseFlagWhenSpeedIsGreatenThan500() {
        trainSensor.overrideSpeedLimit(600);
        verify(trainUserMock, times(1)).setAlarmState(true);
    }

    @Test
    public void RaiseFlagWhenSpeedIsDecreasedBy50Percent() {
        trainSensor.overrideSpeedLimit(200);
        trainSensor.overrideSpeedLimit(50);
        verify(trainUserMock, times(1)).setAlarmState(true);
    }
}
