package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Thread thread;

	public TrainControllerImpl(){
		thread = new Thread(){ //szál létrehozása
			public void run(){
				thread.run(); //közvetlenül meghívja a run-t a jelenlegi szálon
				try{
					followSpeed();
					thread.sleep(5000); //5mp várakozás
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
        if (step > 0) {
            referenceSpeed += step;  //a joystick által vezérelt növelés
            if (referenceSpeed > 10) { //növelés korlátozása 10-re
                referenceSpeed = 10;
            }
        } else {
            referenceSpeed = Math.max(0, referenceSpeed + step);  //csökkentés nem mehet 0 alá
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

}
