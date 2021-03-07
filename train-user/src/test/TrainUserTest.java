package hu.bme.mit.train.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainUserTest {
    @Test
    public void TestgetAlarmFlag() {
        boolean AlarmFlagT=getAlarmFlag();
        assertTrue(AlarmFlagT==false);
    }
}
