package hu.bme.mit.train.tachograph;

import org.junit.Test;
import org.junit.Assert;

public class TachographTest {
    @Test
    public void TestNotEmpty(){
        TrainTachograph tachograph = new TrainTachograph();
        tachograph.addToTachograph(3, 5);
        tachograph.addToTachograph(4, 50000);
        tachograph.addToTachograph(50000, 5);

        Assert.assertNotNull(tachograph.getFromTachograph());
    }
}