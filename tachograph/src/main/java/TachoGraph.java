import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class TachoGraph {
    Table<Integer, Integer, Integer> data = TreeBasedTable.create();

    public void addElement(Integer a, Integer b, Integer c) {
        this.data.put(a, b, c);
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
}
