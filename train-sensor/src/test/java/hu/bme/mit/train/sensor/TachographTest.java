package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TachographTest {

    @Test
    public void JUnitTestForExerciseSix(){
        Point position = new Point(5,10);
        Float speed = 150.43F;
        Tachograph tachograph= new Tachograph(position,speed);
        Assert.assertTrue(tachograph.dataTable.containsValue(speed));
    }

}