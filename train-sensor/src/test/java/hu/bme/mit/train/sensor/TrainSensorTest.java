package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainController controller;
	private TrainUser user;
    private TrainSensorImpl trainSensor;

    //JUnit testek
    @Before
    public void before() {
        controller = new TrainControllerImpl();
        user = new TrainUserImpl(controller);
        user.setAlarmState(false);
        trainSensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void noAlarm(){
       trainSensor.overrideSpeedLimit(100);
       assertFalse("No alarm", user.getAlarmState());
    }

    @Test
    public void under0(){
        trainSensor.overrideSpeedLimit(-1);
        assertTrue("Alarm", user.getAlarmState());
    }
    @Test
    public void above500(){
       trainSensor.overrideSpeedLimit(501);
       assertTrue("Alarm", user.getAlarmState());
    }  

    @Test
    public void underHalf(){
       trainSensor.overrideSpeedLimit(trainSensor.getSpeedLimit() / 2 - 1);
       assertTrue("Alarm", user.getAlarmState());
    }

    private TrainController mockTC;
	private TrainUser mockTU;
    private TrainSensorImpl mockTS;
    
    @Before 
    public void init() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        mockTS = new TrainSensorImpl(mockTC, mockTU); 
    }

    @Test 
    public void under0Mock() {
        mockTS.overrideSpeedLimit(-1);
        Mockito.verify(mockTU).setAlarmState(true);    
    }

    @Test
    public void over500Mock() {
        mockTS.overrideSpeedLimit(501);
        Mockito.verify(mockTU).setAlarmState(true);
    }

    @Test
    public void underHalfMock() {
        mockTS.overrideSpeedLimit(mockTS.getSpeedLimit() / 2 - 1);
        Mockito.verify(mockTU).setAlarmState(true);
    }

    @Test
    public void correctSpeedLimitMock() {
        mockTS.overrideSpeedLimit(mockTS.getSpeedLimit() - 1);
        Mockito.verify(mockTU, Mockito.times(0)).setAlarmState(true);
    }
}
