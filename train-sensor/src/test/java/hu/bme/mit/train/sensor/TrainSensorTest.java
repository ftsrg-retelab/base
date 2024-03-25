package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainSensor;



public class TrainSensorTest {

    private TrainController tc;
    private TrainUser tu;
    private TrainSensor ts;

    @Before
    public void init(){
        tc = mock(TrainController.class);
        tu = mock(TrainUser.class);
        //A sensorhoz nem kell mock, mert ezt az osztalyt teszteljuk, igy nem all fenn fuggoseg
        ts = new TrainSensorImpl(tc, tu); 
    }
    //nem váltunk ki vészjelzést, mert semelyik irányba nem lépjük túl a határokat
    @Test
    public void AlarmNotSet(){
        when(tc.getReferenceSpeed()).thenReturn(220);
        ts.overrideSpeedLimit(250);
        verify(tu, never()).setAlarmState(true);
    }
    //teszteljük a riasztást a felső határnál: 500-nál elvileg még nem riasztunk, felette viszont igen, ezért itt azt 
    //vizsgáljuk, hogy egyszer adunk ki riasztást a 2 sebességfelülírás közül
    @Test
    public void UpperLimitTest(){
        ts.overrideSpeedLimit(500);
        ts.overrideSpeedLimit(501);
        verify(tu, times(1)).setAlarmState(true);
    }
    //teszteljük a riasztást az alsó határnál: 0-nál nem riasztunk, de -1-nél már igen - 1 vészjelzésnek kell lennie
    @Test
    public void LowerLimitTest(){
        when(tc.getReferenceSpeed()).thenReturn(-1);
        ts.overrideSpeedLimit(0);
        ts.overrideSpeedLimit(-1);
        verify(tu, times(1)).setAlarmState(true);
    }
    //teszteljük, hogy az új sebességhatár tényleg 50%-kal lassabb-e, mint a tényleges referenciasebesség
    // a feladatleírásban megadott 50 és 150 számokat használjuk, melyekre riasztani kell
    @Test
    public void SpeedLimitMuchLowerThanReferenceSpeed(){
        when(tc.getReferenceSpeed()).thenReturn(150);
        ts.overrideSpeedLimit(50);
        verify(tu, times(1)).setAlarmState(true);
    }
    
}
