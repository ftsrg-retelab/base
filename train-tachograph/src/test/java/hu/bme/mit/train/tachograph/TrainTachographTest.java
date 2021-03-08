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
	public void checkIfisEmpty() {
		Assert.assertTrue(tachograph.isEmpty());
		tachograph.add(5, 10);
		Assert.assertFalse(tachograph.isEmpty());
	}

}
