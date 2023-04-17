package hu.bme.mit.train.controller;

import com.google.common.collect.HashBasedTable; 
import com.google.common.collect.Table; 
import hu.bme.mit.train.interfaces.TrainController;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class TrainControllerImpl implements TrainController {

	Table<Date, Integer, Integer> logTable = HashBasedTable.create();
	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private boolean speedBoostActive;

	public TrainControllerImpl() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
    	@Override
    	public void run() {
        	followSpeed();
    	}
		}, 2400, 2000);
	}

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

		if (speedBoostActive) {
			referenceSpeed = speedLimit;
		} else {
			enforceSpeedLimit();
		}

		logTable.put(new Date(), step, referenceSpeed);
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
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

	@Override
	public void setSpeedBoostActive(boolean speedBoostActive ) {
		this.speedBoostActive = speedBoostActive ;		
	}

	@Override
	public Table<Date, Integer, Integer> getLogTable() {
		return logTable;
	}

}
