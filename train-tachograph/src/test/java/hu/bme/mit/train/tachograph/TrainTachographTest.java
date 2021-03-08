package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainTachographTest {

        private TrainTachgraph tachograph = new TrainTachgraph();

        @Before
        public void before(){
            tachograph.add(1,2);
        }

        @Test
        public void empty() {
            Assert.assertEquals(false, tachograph.isEmpty());
        }
    }
