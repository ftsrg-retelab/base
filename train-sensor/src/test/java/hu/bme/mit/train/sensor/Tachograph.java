
package hu.bme.mit.train.sensor;

import java.sql.Date;
import java.sql.Time;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;


public class Tachograph{
	public Date currenttime;
	public int joystickposition;
	public double refspeed;
	public Table<Date,Integer,Double> table;
	public Tachograph(Date curr, int pos, double ref){
		currenttime=curr;
		joystickposition=pos;
		refspeed=ref;
		table=ImmutableTable.<Date,Integer,Double>builder().put(curr,pos,ref).build();
		table.put(currenttime, 3, (double) 50);
		table.put(currenttime, 4, (double) 40);
	}
	
	public Table<Date,Integer,Double> gettable(){
		return table;
	}
}