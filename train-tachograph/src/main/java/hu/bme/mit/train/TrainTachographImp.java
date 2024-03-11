package hu.bme.mit.train;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import java.time.LocalDateTime;
import hu.bme.mit.train.interfaces.TrainTachograph;

public class TrainTachographImp implements TrainTachograph 
{
    private Double joy_state = 0.0;
    private Double refSpeed = 0.0;
    private LocalDateTime time;

    public Table<Double,Double,LocalDateTime> table = HashBasedTable.create();
    @Override
    public void setTime(LocalDateTime t)
    {
        time = t;
    }
    @Override
    public void setJoy(Double state)
    {
        joy_state = state;
    }
    @Override
    public void setSpeed(Double speed)
    {
        refSpeed = speed;
    }
    @Override
    public void recordValues()
    {
        table.put(refSpeed,joy_state,time);
    }
}
