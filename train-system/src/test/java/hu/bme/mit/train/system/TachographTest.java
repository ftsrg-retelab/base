package hu.bme.mit.train.system;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.system.Tachograph;

public class TachographTest {
    public Tachograph graph;
    public TrainSystem system;


	@Before
	public void before() {
        system=new TrainSystem();
        graph = new Tachograph(system);
	}

    
    @Test
    public void EntryTest(){

        graph.newInput(0);
        assertEquals(graph.getReferenceSpeed(0,system.getUser().getJoystickPosition()), system.getController().getReferenceSpeed());
    }

}