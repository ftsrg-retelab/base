package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class TachographTest {
	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
		Tachograph x = new Tachograph();
		LocalDateTime time = LocalDateTime.now();
		x.add(time, 1.0, 2.0, 3.0);
		Double[] c = x.get(time, 3.0);
		Assert.assertEquals(1.0, (double)c[0], 0.00);
		Assert.assertEquals(2.0, (double)c[1], 0.00);
	}
}
