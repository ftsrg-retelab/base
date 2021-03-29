package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private final Thread joystick_control;
	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;


	public TrainControllerImpl() {
		joystick_control = new Thread()
		{
			public void run(){
				//System.out.println("MyThread running");
				followSpeed();
				try {
					joystick_control.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		joystick_control.start();
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
