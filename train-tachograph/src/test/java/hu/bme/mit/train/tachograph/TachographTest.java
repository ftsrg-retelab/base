package hu.bme.mit.train.tachograph;

import org.junit.Test;
import org.junit.Assert;

public class TachographTest {
    @Test
    public void TestNotEmpty(){
        TrainTachograph tachograph = new TrainTachograph();
        tachograph.addToTachograph(15, 6);
        Assert.assertFalse(tachograph.isEmpty());
    }
}