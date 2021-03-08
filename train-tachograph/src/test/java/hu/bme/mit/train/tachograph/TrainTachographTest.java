package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainTachographTest {

    TrainTachograph tachograph = new TrainTachographImpl();

    @Before
    public void before() {
        tachograph.putTachographTable(0, 10);
        tachograph.putTachographTable(1, 15);
        tachograph.putTachographTable(1, 20);
    }

    @Test
    public void TachographTest() {
        Assert.assertTrue(!techograph.isEmpty());
        Assert.assertTrue(techograph.containsValue(10));
        Assert.assertTrue(techograph.containsValue(20));
        Assert.assertTrue(techograph.containsColumn(1));
        Assert.assertTrue(techograph.containsColumn(0));
    }
}
