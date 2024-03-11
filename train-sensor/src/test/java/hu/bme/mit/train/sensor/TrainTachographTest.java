package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainTachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainTachographTest {

    private TrainTachograph tachograph;

    @Before
    public void before() {
        tachograph = new TrainTachographImpl();
    }

    @Test
    public void AddValueTest() {
        int timestep = 0;
        int value = 1;
        tachograph.setValueAtTimestep(timestep, "asdf", value);
        int valueFromTable = tachograph.getValueAtTimestep(0, "asdf");
        assert valueFromTable == value;
    }
}
