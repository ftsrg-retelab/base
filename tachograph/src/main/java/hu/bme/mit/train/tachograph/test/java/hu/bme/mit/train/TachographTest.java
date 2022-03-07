package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TachographTest {
    @Test
    void addTest() {
        Tachograph tachograph = new Tachograph;
        tachograph.add(2, 12);
        tachograph.add(6, 20);
        tachograph.add(5, 30);

        assertEquals(3, tachograph.table.size());

    }
}