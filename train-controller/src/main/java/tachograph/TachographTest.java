package tachograph;



import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Time;

import org.junit.Test;




public class TachographTest{
	Tachograph test;
	 @Test
	    public void ThisIsAnExampleTest() {
		 Time time=new Time(0);
	    	test= new Tachograph(time,2, 45.0);
	    	assertFalse(test.table.isEmpty());
	    }
	

}