package hu.bme.mit.train.tachograp;h

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TachTest {
    
    @Test
	public void test() {
		Tachograph tach = new Tachograph(); 
        t.addRecord(1,2,3);
        Assert.assertEquals(2, t.lastPos());  
	}

}
