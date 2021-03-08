import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TachoGraphTest {
    TachoGraph tachoGraph;

    @Before
    public void before() {
        tachoGraph = new TachoGraph();
        tachoGraph.addElement(1, 2, 3);
        tachoGraph.addElement(2, 1, 6);
        tachoGraph.addElement(3, 5, 2);
    }

    @Test
    public void elementTest() {
        Assert.assertTrue(tachoGraph.isEmpty());

    }

}
