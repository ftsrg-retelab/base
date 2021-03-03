import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Container {
    private Table<Long, Integer, Integer> tachograph = HashBasedTable.create();

    public void update(long l1, Integer i1, Integer i2){
        tachograph.put(l1,i1,i2);
    }

    public boolean isEmpty(){
        return tachograph.isEmpty();
    }



}
