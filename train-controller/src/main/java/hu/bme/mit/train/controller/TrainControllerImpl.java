package hu.bme.mit.train.controller;

import java.util.Timer;
import java.util.TimerTask;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private Object referenceSpeedSyncObj = new Object();
	private int speedLimit = 0;
	
	private TimerTask followSpeedTask = new TimerTask() {
		@Override
		public void run() {
			followSpeed();
		}
	};
	private Timer timer = new Timer();
	
	
	public TrainControllerImpl() {
		// 1 mp mulva folyamatosan hivogasd 1 mp-kent
		timer.schedule(followSpeedTask, 1000, 1000);
	}

	@Override
	public void followSpeed() {
		synchronized(referenceSpeedSyncObj) {
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
	}

	@Override
	public int getReferenceSpeed() {
		synchronized(referenceSpeedSyncObj) {
			return referenceSpeed;
		}
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		synchronized(referenceSpeedSyncObj) {
			if (referenceSpeed > speedLimit) {
				referenceSpeed = speedLimit;
			}
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		synchronized(referenceSpeedSyncObj) {
			this.step = joystickPosition;		
		}
	}

}
