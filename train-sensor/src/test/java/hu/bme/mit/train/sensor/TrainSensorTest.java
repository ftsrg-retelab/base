package hu.bme.mit.train.sensor;

import TrainController;
import TrainSensorImpl;
import TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

    public class TrainSensorTest {

    TrainController mockTC;
    TrainUser mockTU;
    TrainsSensorImpl trainSensor;

    @Before
    public void before() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC, mockTU);
    }

    @Test
    public void setAlarmState_TrainUser_Min() {
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void setAlarmState_TrainUser_Max() {
        trainSensor.overrideSpeedLimit(501);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void setAlarmState_TrainUser_RelativeLimit() {
        trainSensor.overrideSpeedLimit(3);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void setAlarmState_TrainUser_Between() {
        trainSensor.overrideSpeedLimit(300);
        verify(mockTU, times(0)).setAlarmState(false);
    }
}
