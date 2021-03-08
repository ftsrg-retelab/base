package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.interfaces.TrainTachograph;


public class TrainTachographTest {

    TrainTachograph tachograph;

    @Before
    public void before() {
        tachograph = new TrainTachographImpl();
        tachograph.putTachographTable(0, 10);
        tachograph.putTachographTable(1, 15);
        tachograph.putTachographTable(1, 20);
    }

    @Test
    public void TachographTest() {
        Assert.assertTrue(!tachograph.isEmpty());
        Assert.assertTrue(tachograph.containsValue(10));
        Assert.assertTrue(tachograph.containsValue(20));
        Assert.assertTrue(tachograph.containsColumn(1));
        Assert.assertTrue(tachograph.containsColumn(0));
    }
}
