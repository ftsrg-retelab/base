package hu.bme.mit.train.sensor;

import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;


import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl trainSensor;   

    @Before
    public void before() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC, mockTU);
        when(mockTC.getReferenceSpeed()).thenReturn(140);
    } 

    @Test
    public void AbsulateMarginMax() {
        trainSensor.overrideSpeedLimit(510);
        verify(mockTU, times(1)).setAlarmState(true); 
    }

    @Test
    public void AbsulateMarginMin() {
        trainSensor.overrideSpeedLimit(-10);
        verify(mockTU, times(1)).setAlarmState(true); 
    }

    @Test
    public void Between() {
        trainSensor.overrideSpeedLimit(220);
        verify(mockTU, times(0)).setAlarmState(false); 
    }

    @Test
    public void RealMargin() {
        trainSensor.overrideSpeedLimit(4);
        verify(mockTU, times(1)).setAlarmState(true); 
    }
    

}
