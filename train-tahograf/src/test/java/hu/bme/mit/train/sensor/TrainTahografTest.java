package hu.bme.mit.train.tahograf;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import static org.mockito.Mockito.*;

public class TrainTahografTest {
    TrainTahografImpl imp;
    @Before
	public void before() {
        imp = new TrainTahografImpl();
	}
    @Test
    public void TestSmokes() {
        Assert.assertNotNull(imp.getTable());
    }
}
