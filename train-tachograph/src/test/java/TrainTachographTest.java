import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TrainTachographTest {

    private TrainTachograph tt = new TrainTachograph();

    @Before
    public void before(){
        tt.updateTable(1, 5);
    }

    @Test
    public void containsElements() {
        assertTrue(tt.getTable().isEmpty());
    }
}
