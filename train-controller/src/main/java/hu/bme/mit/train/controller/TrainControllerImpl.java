package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import java.util.TimerTask;
import java.util.Timer;  

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	boolean timerStarted = false; 
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			followSpeed(); 
		} 
	};

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
	public int getSpeedLimit() {
		return speedLimit; 
	}  

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		// The speed limit can never be a negative number, so the issue has never existed
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
		if (!timerStarted) {
			timer.scheduleAtFixedRate(task, 0, 1000);
			timerStarted = true; 
		} 
	}

}
