package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import com.google.common.collect.*;
import com.google.common.collect.Table;
import java.text.SimpleDateFormat;


public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	Table<String, Integer, Integer> tachoGrafTable = TreeBasedTable.create();
	

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}
		

		
		emergencyBreak(referenceSpeed);
		enforceSpeedLimit();
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new java.util.Date());
		tachoGrafTable.put(date, 1, step);
		tachoGrafTable.put(date, 2, referenceSpeed);
		
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	

	@Override
	public int getSpeed(String date) {
		return tachoGrafTable.get(date, 2);
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

	public void emergencyBreak(int referenceSpeed){
		if(referenceSpeed>speedLimit){
			referenceSpeed = 0;
		}
	}

}
