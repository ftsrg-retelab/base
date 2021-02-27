import com.google.common.collect.Table;
import org.junit.jupiter.api.DynamicTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TrainTachographTest {
    @Test
    public void isThereanyElements(){
        TrainTachograph tachnograph= new TrainTachograph();
        tachnograph.addNewRecord(16,56);
        Table<Date,Integer,Integer> table =tachnograph.readTable();
        Assert.assertFalse(table.isEmpty());
    }
}
