package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.sensor.*;

import org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainUser user;
    private TrainController trainController;
    private TrainSensor sensor;

    @Before
    public void before() {
       
        trainController = mock(TrainController.class);  
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(trainController,user);

    }



    @Test
    public void Test1() {
        when(trainController.getReferenceSpeed()).thenReturn(10);
        sensor.overrideSpeedLimit(10);
        verify(user).setAlarmState(false);    
    }

    @Test
    public void Test2() {
        when(trainController.getReferenceSpeed()).thenReturn(-10);
        sensor.overrideSpeedLimit(-10);
          verify(user).setAlarmState(true);    
    }

    @Test
    public void Test3() {
        when(trainController.getReferenceSpeed()).thenReturn(501);
        sensor.overrideSpeedLimit(501);
        verify(user).setAlarmState(true);  
    }

   @Test
    public void Test4() {
        when(trainController.getReferenceSpeed()).thenReturn(0);
        sensor.overrideSpeedLimit(15);
        verify(user).setAlarmState(false);  
    } 
}
