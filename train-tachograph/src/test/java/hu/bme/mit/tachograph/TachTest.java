package hu.bme.mit.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import com.google.common.collect.Table;

public class TachTest {

    @Test
    public void ThisIsAnExampleTestStub() {
        Tachograph tach = new Tachograph();
        tach.add(new Date(2020,05,06), 10, 50);

        Table table = tach.getTachographTable();
        
		Assert.assertEquals(table.isEmpty(), false);
        
    }
}
