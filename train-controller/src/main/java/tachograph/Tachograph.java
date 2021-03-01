
package tachograph;

import java.sql.Time;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;


public class Tachograph{
	Time currenttime;
	int joystickposition;
	double refspeed;
	Table<Time,Integer,Double> table;
	public Tachograph(Time curr, int pos, double ref){
		currenttime=curr;
		joystickposition=pos;
		refspeed=ref;
		table=ImmutableTable.<Time,Integer,Double>builder().put(curr,pos,ref).build();
		table.put(currenttime, 3, (double) 50);
		table.put(currenttime, 4, (double) 40);
	}
}