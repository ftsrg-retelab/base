import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TachographTest {
    TrainTachograph tacho;

    @Before
    public void before() {
        tacho = new TrainTachograph("1","2","3");
    }

    @Test
    public void Element() {
        Assert.assertEquals(expected: false, tacho.tachographTable.isEmpty());
    }
}
