package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl trainSensor;

    @Before
    public void init() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC, mockTU);
    }

    @Test
    public void Limit_UnderAbs_Alarm() {
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void Limit_AboveAbs_Alarm() {
        trainSensor.overrideSpeedLimit(501);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void Limit_UnderRel_Alarm() {
        trainSensor.overrideSpeedLimit(2);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void Limit_Proper_NoAlarm() {
        trainSensor.overrideSpeedLimit(3);
        verify(mockTU, times(1)).setAlarmState(false);
    }
}
