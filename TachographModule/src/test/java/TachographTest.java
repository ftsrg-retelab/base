import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TachographTest {
    Tachograph tachograph;

    @Before
    public void Initialization(){
        tachograph = new Tachograph();
    }

    @Test
    public void Test(){
        tachograph.add(11,77);
        Assert.assertFalse(tachograph.isEmpty());
    }
}
