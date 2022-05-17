package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
	private int speedLimit = 5;

    //JUnit testek
    @Before
    public void before() {
        
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
    public void moreThan50Percent(){
       trainSensor.overrideSpeedLimit(speedLimit / 2 - 1);
       assertTrue("Alarm", user.getAlarmState());
    }

    //Mock tesztek
    @Before
    public void before2() {
        
        user.setAlarmState(false);
        trainSensor = new TrainSensorImpl(controller, user);
    }
    private TrainController mockTC;
	private TrainUser mockTU;
    private TrainSensorImpl mockTS;
	private int mockSpeedLimit = 5;
    
    @Before 
    public void init() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        mockTS = new TrainSensorImpl(mockTC, mockTU); 
    }

    @Test 
    public void under0Mock() {
        mockTS.overrideSpeedLimit(10);
        Mockito.verify(mockTU).setAlarmState(true);    
    }  
}
