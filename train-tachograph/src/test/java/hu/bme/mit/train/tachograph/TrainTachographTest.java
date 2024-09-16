package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Assert;
import org.junit.Test;

public class TrainTachographTest {
    @Test
    public void givenTable_whenGet_returnsSuccessfully() {
        Table<Integer, String, Integer> testTachograph
                = HashBasedTable.create();
        testTachograph.put(1615147200, "Up", 2);
        testTachograph.put(1615147201, "Down", 2);
        testTachograph.put(1615147202, "Up", 3);
        testTachograph.put(1615147203, "Up", 4);

        int startSpeed = testTachograph.get(1615147200, "Up");
        Integer nonexistentSpeed = testTachograph.get(1615161600, "Up");

        Assert.assertEquals(startSpeed, 2);
        Assert.assertNull(nonexistentSpeed);
    }
}
