package hu.bme.mit.train.interfaces;
import java.time.LocalDateTime;
public interface TrainTachograph {

	void setTime(LocalDateTime t);
    void setJoy(Double state);
    void setSpeed(Double speed);
    void recordValues();

}