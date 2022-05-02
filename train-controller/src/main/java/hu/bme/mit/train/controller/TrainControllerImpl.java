package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import java.util.Timer;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private boolean emergencyBrakeEngaged = false;
	Timer timer = new Timer();
	TimerTas tt = new TimerTask() {
	    @Override
	    public void run() {
		referenceSpeed += step;
		enforceSpeedLimit();
	    }
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
		if(step > 0)
		{
			tt.cancel();
			timer.cancel();	
			tt = new TimerTask() {
			    @Override
			    public void run() {
				referenceSpeed += step;
				enforceSpeedLimit();
			    }
			}
			timer.scheduleAtFixedRate(tt, 1000, 1000);
		}
		else if (step == 0)
		{
			tt.cancel();
			timer.cancel();
		}		
		else if (step < 0)
		{
			tt.cancel();
			timer.cancel();
			tt = new TimerTask() {
			    @Override
			    public void run() {
				referenceSpeed -= step;
				if(referenceSpeed < 0)
				{
					referenceSpeed = 0;				
				}
			    }
			}
		}
	}

	@Override
	public boolean isEmergencyBrakeEngaged()
	{
		return emergencyBrakeEngaged;
	}

}
