import hu.bme.mit.train.tachograph.TrainTachograph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainTachographTest {
    TrainTachograph trainTachograph;

    @Before
    public void before() {
        trainTachograph = new TrainTachograph();
    }

    @Test
    public void TestCollectionElementNotEmpty() {
        trainTachograph.record();
        Assert.assertFalse(trainTachograph.getRecordTable().isEmpty());

    }
}
