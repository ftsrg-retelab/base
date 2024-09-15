package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Dashboard dashboard = new Dashboard(referenceSpeed,step);

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
		dashboard.setPosition(step);
		dashboard.setSpeed(referenceSpeed);
		dashboard.showDashboard();
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
		dashboard.setSpeed(referenceSpeed);
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
		dashboard.setPosition(joystickPosition);
		followSpeed(); //This call makes the difference.
	}

}
