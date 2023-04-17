package hu.bme.mit.train.controller;

import javax.sound.midi.Transmitter;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private boolean forceStopMode = false;

	static Timer timer = new Timer();

	public TrainControllerImpl(){
		MyTimer();
	}

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

	public static void MyTimer() {

		TimerTask task;


		task = new TimerTask() {
			@Override
			public void run() {
				followSpeed();
			}
		};
		timer.schedule(task, 0, 1000);

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
