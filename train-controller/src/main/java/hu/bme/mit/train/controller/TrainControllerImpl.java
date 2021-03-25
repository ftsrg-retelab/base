package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;


class UpdateSpeed extends TimerTask {
	private TrainController trainController;

	public UpdateSpeed(TrainController trainController) {
		this.trainController = trainController;
	}

	@Override
	public void run() {
		this.trainController.followSpeed();
	}
}

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Timer timer;

	@Override
	public void followSpeed() {
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

	public void seedUpdateTimerStart(int l) {
		timer.schedule(new UpdateSpeed(this), l);
	}

}
