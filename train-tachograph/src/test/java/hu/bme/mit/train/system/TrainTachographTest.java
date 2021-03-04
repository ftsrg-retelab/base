package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Test;

public class TrainTachographTest {
	private TrainTachograph trainTachograph = new TrainTachograph();

	@Test
	public void ElementCheck() {
		trainTachograph.add(5, 10);
		trainTachograph.add(6, 11);
		trainTachograph.add(7, 12);

		Assert.assertEquals(3, trainTachograph.get().size());
	}
}
