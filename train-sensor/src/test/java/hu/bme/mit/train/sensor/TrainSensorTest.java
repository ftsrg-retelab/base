package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class TrainSensorTest {

    private TrainSensorImpl trainSensor;

    @Before
    public void before() {
        trainSensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void testAddRecord() {
        String date = "2024-03-10";
        Integer joystickPosition = 3;
        Integer referenceSpeed = 50;

        trainSensor.addRecord(date, joystickPosition, referenceSpeed);

        Table<String, Integer, Integer> tachnographTable = trainSensor.tachnographTable;
        Assert.assertTrue(tachnographTable.contains(date, joystickPosition));
        Assert.assertEquals(referenceSpeed, tachnographTable.get(date, joystickPosition));
    }
}
