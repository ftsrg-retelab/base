package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
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
        trainControllerMock=mock(TrainController.class);
        trainUserMock=mock(TrainUser.class);
        trainSensor=new TrainSensorImpl(trainControllerMock,trainUserMock);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void checkSpeedLimit() {
        Assert.assertEquals(20,20);
    }

    @Test
    public void AbsMarginMin() {
        trainSensor.overrideSpeedLimit(-20);
        verify(trainUserMock,times(1)).setAlarmState(true);
    }

    @Test
    public void AbsMarginMax() {
        trainSensor.overrideSpeedLimit(520);
        verify(trainUserMock,times(1)).setAlarmState(true);
    }

    @Test
    public void RelMargin() {
        trainSensor.overrideSpeedLimit(8);
        verify(trainUserMock,times(1)).setAlarmState(true);
    }

    @Test
    public void MarginBtw() {
        trainSensor.overrideSpeedLimit(230);
        verify(trainUserMock,times(1)).setAlarmState(false);
    }


}
