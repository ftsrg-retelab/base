package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TachographTest{

    Tachograph tac = new Tachograph;

    @Before
    public void before(){
        tac.add(10, 10);
        tac.add(20, 10);

    }

    @Test
    public void store(){
		assertEquals(2, tac.tachograph.size());
    } 
} 