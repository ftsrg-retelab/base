package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import com.google.common.collect.Table;

import java.time.LocalTime;

public class TrainSensorTest {

    private TrainSensorImpl trainSensor;

    @Before
    public void setUp() {
        trainSensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void testTachographRecording() {
        // Hozzáadunk néhány elemet a tachográfhoz
        trainSensor.recordData();
        trainSensor.recordData();
        trainSensor.recordData();

        // Ellenőrizzük, hogy három elem került-e a tachográfba
        Table<LocalTime, Integer, Integer> tachograph = trainSensor.getTachograph();
        assertEquals(3, tachograph.size());
    }
}
