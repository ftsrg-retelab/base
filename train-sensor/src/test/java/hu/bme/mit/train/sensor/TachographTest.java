
package hu.bme.mit.train.sensor;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Table;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.sql.Date;
import java.sql.Time;



    
public class TachographTest{
	Tachograph test;
	
	@Before
    public void before() {
    	
        // TODO Add initializations
    }

	 @Test
	    public void ThisIsAnExampleTest() {
		 Date time=new Date(0);
		 test= new Tachograph(time,2, 45.0);
		 Table<Date,Integer,Double> table=test.gettable();
	    	
	    	assertFalse(table.isEmpty());
	    }
	

}