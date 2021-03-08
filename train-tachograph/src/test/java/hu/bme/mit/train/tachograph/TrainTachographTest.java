package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainTachographTest {

    @Before
    public void before() {
        TachographTable.putTachographTable(0, 10);
        TachographTable.putTachographTable(1, 15);
        TachographTable.putTachographTable(1, 20);
    }

    @Test
    public void TachographTest() {
        Assert.assertTrue(!TachographTable.isEmpty());
        Assert.assertTrue(TachographTable.containsValue(10));
        Assert.assertTrue(TachographTable.containsValue(20));
        Assert.assertTrue(TachographTable.containsColumn(1));
        Assert.assertTrue(TachographTable.containsColumn(0));
    }
}
