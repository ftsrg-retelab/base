package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController, Runnable {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
				//This was modified for the previous task
				//Was set to correct value for passing test
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
		try {
			this.step = joystickPosition;
			Thread.sleep(200);	
		} catch (Exception e) {
			System.out.println("thread exception");
		}
			
	}

	@Override
	public void emergencyBrake(){
		this.referenceSpeed=0;
	}


	public void run(){
		while(true){
			followSpeed();
		}
	}
}
