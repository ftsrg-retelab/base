package hu.bme.mit.train.tachograf;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.tachograf.TrainTachograf;

public class TrainTachografTest {

    @Test
    public void TestTachograf() {
        TrainTachograf trainTachograf = new TrainTachograf();
        if(trainTachograf.tachografTable != null)
        	System.out.println("A tachograf ures!");
        else
        	System.out.println("A tachograf nem ures!");
    }
}
