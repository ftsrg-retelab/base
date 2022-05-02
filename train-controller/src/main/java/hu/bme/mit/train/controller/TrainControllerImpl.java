package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Timer timer = new Timer("Timer");

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

	public void changeReferenceSpeed(){
		TimerTask task = new TimerTask() {
			public void run() {
				setJoystickPosition(5);
				referenceSpeed++;
				while(joystickPosition > 0){
					if(referenceSpeed< speedLimit ){
						referenceSpeed++;
					}
				}
			}
		};
		TimerTask task2 = new TimerTask(){
			public void run(){
				setJoystickPosition(-5);
				referenceSpeed--;
				while(joystickPosition < 0){
					referenceSpeed++;
				}
			}
		};
		timer.schedule(task, 1000L);
		timer.schedule(task2, 2000L);		
	}
}
