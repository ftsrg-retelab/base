import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TachographTest {
    TrainController controller;
    TrainUser user;
    TrainTachograph tachograph;

    @Before
    public void before() {
        TrainSystem system=new TrainSystem();
        controller = system.getController();
        user = system.getUser();
        tachograph=new TrainTachograph();

    }

    @Test
    public void tableEntryTest(){
        tachograph.AddTachograph(user.getJoystickPosition(), controller.getReferenceSpeed());
        Assert.assertNotNull(tachograph.GetTachograph());
    }
}
