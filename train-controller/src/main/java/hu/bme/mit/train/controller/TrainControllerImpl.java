package hu.bme.mit.train.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
public class TrainControllerImpl implements TrainController {
	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Thread t;

	public TrainControllerImpl(){
		t = new Thread() {
			public void run(){
				t.run();
				try{
					followSpeed();
					thread.sleep(2000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		};
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
	@Override
	public void setSpeedToNull(){
		setSpeedLimit(0);
		enforceSpeedLimit();
	}
	@Override
	public void emergencyBreaking() {
		setSpeedToNull();
	}

}