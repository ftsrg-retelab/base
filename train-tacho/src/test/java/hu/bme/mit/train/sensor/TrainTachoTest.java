package hu.bme.mit.train.tacho;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Date;

public class TrainTachoTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        TrainTacho tacho = new TrainTacho();
        tacho.add(new Date(), 1, 1);
        Assert.assertFalse(tacho.isEmpty());
    }
}
