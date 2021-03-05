import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TrainTachographTest {

    private TrainTachograph tt = new TrainTachograph();

    @Before
    public void before(){
        tt.updateTable(1, 5);
    }

    @Test
    public void containsElements() {
        assertFalse(tt.getTable().isEmpty());
    }
}
