package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainButton {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private boolean forceStopMode = false;

	@Override
	public void followSpeed() {
		if (forceStopMode) {
			while (referenceSpeed > 0) {
				referenceSpeed -= (step * 3);
			}
			if (referenceSpeed < 0) {
				referenceSpeed = 0;
			}
		} else {
			if (referenceSpeed < 0) {
				referenceSpeed = 0;
			} else {
				if (referenceSpeed + step > 0) {
					referenceSpeed += step;
				} else {
					referenceSpeed = 0;
				}
			}

			enforceSpeedLimit();
		}
	}

	public void setForceStopMode(boolean forceStopMode) {
		this.forceStopMode = forceStopMode;
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
