package hu.bme.mit.train.tachograph;

import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class TrainTachographImplTest {

    @Test
    void insertValue() {
        TrainTachographImpl tachograph = new TrainTachographImpl();
        Time time = new Time(5);
        tachograph.insertValue(time, 15,20);
        assertEquals(tachograph.numberOfRecords(),1);

    }

    @Test
    void numberOfRecords() {
    }
}