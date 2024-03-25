package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private boolean em_break = false;

	@Override
	public void followSpeed() {
		if(em_break){
			referenceSpeed = 0;
		}else{
			if (referenceSpeed < 0) {
				referenceSpeed = 0;
			} else {
				if(joystickPosition > 0){
					if(referenceSpeed+step < speedLimit) {
						referenceSpeed += step;
					}else{
						referenceSpeed = speedLimit;
					}
				}else if(joystickPosition < 0){
					referenceSpeed -= step;
				}
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
		if(em_break){
			this.step = 0;
		}else{
			this.step = joystickPosition;
			
		}
	}
	public void setEm_Break(boolean em_break){
		this.em_break = em_break;
	}
}

public class MyScheduler {

    // Define your task (replace the code inside run() with your desired functionality)
    private static Runnable task = () -> {
        System.out.println("Hello, world!"); // Example: Print "Hello, world!" every second
    };

    public static void startScheduler() {
        // Create a single-threaded executor
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Schedule the task to run every 1 second
        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

        // Clean up the executor when your program exits
        // (important to prevent resource leaks)
        executor.shutdown();
    }
}
