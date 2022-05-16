package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	public TrainControllerImpl(){
		this.super();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		@Override
		public void run() {
			this.followSpeed();
		}
		}, 0, 1000);//wait 0 ms before doing the action and do it evry 1000ms (1second)

		timer.cancel();s
	} 

	public void emergencyBreak() {
		speedLimit = 0;
		referenceSpeed = 0; 
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
		if(joystickPosition > 0 ){ this.referenceSpeed++;}
		else if (joystickPosition < 0){
			this.referenceSpeed--;
		}

	}

	@Override
	public String toString() {

		return step + ", referenceSpeed: " + referenceSpeed + ", " + speedLimit;
	}


}
