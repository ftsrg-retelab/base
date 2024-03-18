package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer; 
import java.util.TimerTask; 

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	class FunctionTimer extends TimerTask 
	{ 
		public void run() 
		{ 
			followSpeed();
		}
	}

	public TrainControllerImpl() {
		Timer timer = new Timer();
		TimerTask task = new FunctionTimer();

		timer.schedule(task, 0, 1000);
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

		enforceSpeedLimit();
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

	public void emergencyBreak() {
		this.referenceSpeed = 0;
	}
	
	

}