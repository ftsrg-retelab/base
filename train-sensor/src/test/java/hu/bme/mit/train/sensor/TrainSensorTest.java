package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController TC;
    TrainUser User;
    TrainSensorImpl TS;
    @Before
    public void before() {
        // TODO Add
        TC = mock(TrainController.class);
        User = mock(TrainUser.class);
        TS= new TrainSensorImpl(TC, User);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void testminMargin()
    {
        TS.overrideSpeedLimit(-1);
        verify(User, times(1)).setAlarmState(true);

    }


    @Test
    public void testmaxMargin()
    {
        TS.overrideSpeedLimit(501);
        verify(User, times(1)).setAlarmState(true);

    }

    @Test
    public void testrelMargin()
    {
        TS.overrideSpeedLimit(1);
        verify(User, times(1)).setAlarmState(true);

    }

    @Test
    public void testbetwMargin()
    {
        TS.overrideSpeedLimit(300);
        verify(User, times(1)).setAlarmState(false);

    }
    @Test
    public void testgetMargin()
    {
        TS.overrideSpeedLimit(200);
        Assert.assertEquals(200,TS.getSpeedLimit());
    }
}
