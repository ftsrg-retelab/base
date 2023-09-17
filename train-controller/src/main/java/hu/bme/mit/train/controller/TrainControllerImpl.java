package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import java.lang.Thread;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	private Thread thread;
	private boolean active = true;

	public TrainControllerImpl(){
		thread = new Thread( new Runnable() {
			@Override
			public void run(){
				try {
					threadForSpeedSet();
				}
				catch(InterruptedException e) {
					System.out.println("Interrupted");
				}

			}
		});
		thread.start();
	}

	public void threadForSpeedSet() throws InterruptedException{
		while(active){
			followSpeed();
			Thread.sleep(1000);
		}
	}

	public void stopThread(){
		active = false;
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

}
