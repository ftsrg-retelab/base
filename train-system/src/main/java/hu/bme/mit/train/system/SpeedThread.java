package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.system.TrainSystem;
import java.lang.Thread;

public class SpeedThread extends Thread {
    private TrainController controller;

    public SpeedThread(TrainController tc){
        controller=tc;
    }

	public void run()  {
		while (true) {
            try{
			Thread.sleep(1000);
			controller.followSpeed();
            }
            catch (InterruptedException e){
                System.out.println("Exception");
            }
		}
	}
}
