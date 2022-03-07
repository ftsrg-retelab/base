package hu.bme.mit.train.tachograph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TachographTest {

    @Test
    void addTest() {
        Tachograph tg = new Tachograph();

        tg.add(1,20);
        tg.add(1,25);

        assertEquals(2, tg.mTable.size());
    }

}
