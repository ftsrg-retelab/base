package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        System.out.println("JUnit test by @Bence56");
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void excercise4DOT7Test(){

        int a =2;
        int b=-2;
        int res = a+b;
        Assert.assertEquals(0,res);
    }

}
