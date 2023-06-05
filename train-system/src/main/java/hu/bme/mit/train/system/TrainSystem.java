package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private boolean IsBrakeOn = false;
	private int CurrentSpeed = 100;

	public TrainController getController() {
		return controller;
	}


	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	public int EmergencyBrake(boolean IsBrakeOn,int CurrentSpeed){
		if (CurrentSpeed > 160 ){
			IsBrakeOn = true;
		}
		return 0;
	}

}
	
