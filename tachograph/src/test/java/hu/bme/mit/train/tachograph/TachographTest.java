package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TachographTest {
    Tachograph tg;

    @Before
    public void before(){
        tg = new Tachograph();
    }

    @Test
    public void TableIsEmpty(){
        tg.add(3, 23);
        Assert.assertEquals(true, tg.isEmpty());
    }

}
