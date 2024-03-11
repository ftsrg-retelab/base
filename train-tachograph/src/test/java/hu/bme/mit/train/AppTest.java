package hu.bme.mit.train;

import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import org.junit.Test;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import java.time.LocalDateTime;
import hu.bme.mit.train.interfaces.TrainTachograph;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void addToTable()
    {
        TrainTachographImp tt = new TrainTachographImp();
        tt.setJoy(0.5);
        tt.setSpeed(0.3);
        tt.setTime(LocalDateTime.now());
        tt.recordValues();
        assertTrue(tt.table.size() > 0);
    }
}
