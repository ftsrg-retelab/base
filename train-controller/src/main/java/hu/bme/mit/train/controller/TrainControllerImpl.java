package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;

public class TrainControllerImpl implements TrainController {

	private int step1 = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;


	public TrainControllerImpl(){
		TimerTask task = new TimerTask() {
			public void run() {
				followSpeed();
			}
		};
		Timer timer = new Timer();

		long delay = 1000L;
		timer.schedule(task, delay);
	}



	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+ step1 > 0) {
                referenceSpeed += step1;
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
		this.step1 = joystickPosition;
	}

}
