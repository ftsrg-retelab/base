package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;


public class TachographTest {
    private Tachograph tachograph;

    @Before
    public void before(){
        tachograph = new Tachograph();
        tachograph.record(Calendar.getInstance().getTime(), 5, 10);
    }

    @Test
    public void TestEmpty(){
        Assert.assertFalse(tachograph.isEmpty());
    }

}
