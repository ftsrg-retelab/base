package hu.bme.mit.train.tacho;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Date;

public class TrainTacho {

	Table<Date,Integer,Integer> tacho  = HashBasedTable.create();

	public void add(Date date, Integer a, Integer b) {
		tacho.put(date,a,b);
	}

	public boolean isEmpty() {
		return tacho.isEmpty();
	}

}
