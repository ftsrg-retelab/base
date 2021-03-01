package hu.bme.mit.train.tachograph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainTachographTest {
    TrainTachograph tachograph;

    @Before
    public void before() {
        tachograph = new TrainTachograph();
    }

    @Test
    public void testRecordAdding() {
        int timestamp = 1614614605;
        String position = "forward";
        int speed = 5;
        tachograph.addRecord(timestamp, position, speed);
        Assert.assertEquals(speed, (int) tachograph.records.get(timestamp, position));
    }
}