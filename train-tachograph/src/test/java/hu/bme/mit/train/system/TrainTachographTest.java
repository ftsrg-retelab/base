package hu.bme.mit.train.system;

import hu.bme.mit.train.tachograph.TrainTachograph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainTachographTest {

    private TrainTachograph tachograph;

    @Before
    public void before() {
        tachograph = new TrainTachograph();
    }

    @Test
    public void TableHasElements() {
        Assert.assertFalse(tachograph.TableIsEmpty());
    }
}
