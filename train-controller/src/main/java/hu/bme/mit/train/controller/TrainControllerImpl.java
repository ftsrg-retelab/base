package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.tachograph.*;

import java.time.LocalDateTime;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private TrainTachograph tachograph = TrainTachograph.getInstance();


	/// The function was already implemented in the original MIT1 lab and thus in my solution as well.
	/// The test run perfectly fine, following the readme.md
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
		tachograph.AddEntry(LocalDateTime.now(), step, referenceSpeed);

	}

	@Override
	public int getReferenceSpeed() {

		System.out.println(referenceSpeed);
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
