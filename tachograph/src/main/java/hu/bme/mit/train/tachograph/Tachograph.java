package hu.bme.mit.train.tachograph;

import com.google.common.collect; 

public class Tachograph{

    Table<Integer, Integer, Integer> tach; 

    public Tachograph(){
        tach = HashBasedTable.create(); 
    } 

    void addRecord(int t, int p, int s){
        tach.put(t, p, s);  
    }
    
    int lastPos(){
        return 2; 
    } 

} 