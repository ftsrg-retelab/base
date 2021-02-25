package hu.bme.mit.train.tachograph;

import org.junit.Test;
import org.junit.Assert;

public class TrainTachographTest {
    @Test
    public void TestIfCollectionHasSomeElements(){
        TrainTachograph tachograph = new TrainTachograph();
        tachograph.AddToTachograph(3, 5);
        tachograph.AddToTachograph(4, 50000);
        tachograph.AddToTachograph(50000, 5);

        Assert.assertNotNull(tachograph.GetFromTachograph());
    }
}
