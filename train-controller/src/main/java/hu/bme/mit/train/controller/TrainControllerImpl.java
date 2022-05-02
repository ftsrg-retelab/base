package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private int minimumSpeed = 0;
	private Tachometer tachometer;

	public TrainControllerImpl(){
		super();
		tachometer = new Tachometer();
	}

	public Tachometer getTachometer() {
		return tachometer;
	}

	@Override
	public boolean isTachometerEmpty() { return tachometer.isEmpty(); }
	
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
		tachometer.addDataToTachometer(step, referenceSpeed);
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit, int minimumSpeed) {
		this.speedLimit = speedLimit;
		this.minimumSpeed = minimumSpeed;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
		if (referenceSpeed < minimumSpeed) {
			referenceSpeed = minimumSpeed;
		}
	}

	
    public void run() {
        long startTime = System.currentTimeMillis();
        int i = 0;
        while (true) {
            
            try {
				if(joystickPosition>0)
					followSpeed();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;	
			run();
		
	}

}
