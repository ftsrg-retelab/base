import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainerTest {

    Integer refspeed ;
    Integer joystickpos;
    Container cont= new Container();

    @Before
    public void before() {
        refspeed = 40;
        joystickpos = 2;
    }

    @Test
    public void simpleTest() {
        cont.update(System.currentTimeMillis(),joystickpos,refspeed);


        Assert.assertFalse(cont.isEmpty());
    }


}
