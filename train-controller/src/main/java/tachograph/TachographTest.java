package tachograph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.sql.Time;

import org.junit.Test;

import com.google.common.*;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.sql.Time;

import hu.bme.mit.train.sensor.TrainSensorImpl;

public class TachographTest{
	Tachograph test;
	 @Test
	    public void ThisIsAnExampleTest() {
		 Time time=new Time(0);
	    	test= new Tachograph(time,2, 45.0);
	    	assertFalse(test.table.isEmpty());
	    }
	

}