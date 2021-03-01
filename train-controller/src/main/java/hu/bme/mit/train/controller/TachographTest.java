
package hu.bme.mit.train.controller;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import java.sql.Time;



    
public class TachographTest{
	Tachograph test;
	
	@Before
    public void before() {
    	
        // TODO Add initializations
    }

	 @Test
	    public void ThisIsAnExampleTest() {
		 Time time=new Time(0);
	    	test= new Tachograph(time,2, 45.0);
	    	assertFalse(test.table.isEmpty());
	    }
	

}