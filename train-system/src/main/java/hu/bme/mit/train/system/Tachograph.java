package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Tachograph{

    private Table<Integer, Integer, Integer> table;
    private TrainSystem system;

    public Tachograph(TrainSystem system){
        table = HashBasedTable.create();
        this.system=system;
    }

    public void newInput(Integer time){
        table.put(time, system.getUser().getJoystickPosition(), system.getController().getReferenceSpeed());
    }

    public int getReferenceSpeed(int time, int joystickPosition){
        return table.get(time, joystickPosition);
    }

}