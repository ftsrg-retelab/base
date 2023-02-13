package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class TachographTest {
	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
		Tachograph x = new Tachograph();
		LocalDateTime time = LocalDateTime.now();
		x.add(time, 1, 2);
		Integer speed = x.get(time, 1);
		Assert.assertEquals(2, (int)speed);
	}
}
