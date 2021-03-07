package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import java.time.LocalDateTime;


public class TrainTachograph implements Table{

	private Table<LocalDateTime, Integer, Integer> valami;

	public TrainTachograph() {

	}

}
