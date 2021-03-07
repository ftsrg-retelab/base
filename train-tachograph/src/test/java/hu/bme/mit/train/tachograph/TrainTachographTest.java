package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TrainTachographTest {

    TrainTachograph tt;
    @Before
    public void before() {
        tt = new TrainTachograph();
    }

    @Test
    public void test() {
        tt.addPosAndSpeed(4,5);
        tt.addPosAndSpeed(4,6);
        tt.addPosAndSpeed(-4,25);
        Assert.assertEquals(3, tt.getElementCount());

    }
}