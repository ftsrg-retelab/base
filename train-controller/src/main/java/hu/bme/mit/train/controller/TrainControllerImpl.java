package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import java.util.*;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	// Timer attribute to handle time-based changes
	private Timer timer = new Timer("timer");

	// the constructor of this class initiates a timertask that's "called" every passing second
	public TrainControllerImpl() {
		TimerTask tTask = new TimerTask() {
			public void run() {
				followSpeed();
			}
		};

		timer.schedule(tTask, 1000L);
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
	public void emergencyBreak() {
		referenceSpeed = 0;
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

}
